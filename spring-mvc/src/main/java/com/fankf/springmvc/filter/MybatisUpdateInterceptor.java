package com.fankf.springmvc.filter;

import com.fankf.springmvc.config.TableColumnConfig;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;
import java.util.*;

@Component
@Intercepts(@Signature(method = "update", type = Executor.class, args = { MappedStatement.class, Object.class }))
public class MybatisUpdateInterceptor implements Interceptor {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private TableColumnConfig tableColumnConfig;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		if (SqlCommandType.SELECT == sqlCommandType) {
			return invocation.proceed();
		}
		Object paramObj = invocation.getArgs()[1];
		if (paramObj instanceof Map) {
			Map parm = (Map) paramObj;
			Object list = parm.get("list");
			if (list != null) {
				return invocation.proceed();
			}
		}
		BoundSql sql = mappedStatement.getBoundSql(paramObj);
		List<String> tables = getTableNames(sql.getSql());
		List<String> interceptTableNames = tableColumnConfig.getAllTableNames();
		for (String tableName : interceptTableNames) {
			if(tableName.equals(tables.get(0))) {
				boolean isContainColumn = false;
				List<String> interceptColumnNames = tableColumnConfig.getAllColumns(tableName);
				for (String columnName : interceptColumnNames) {
					if(sql.getSql().contains(columnName)) {
						isContainColumn = true;
						break;
					}
				}
				if(isContainColumn) {
					Class paramClass = paramObj.getClass();
					if (SqlCommandType.INSERT == sqlCommandType) {
						StringBuilder perpareMacStr = new StringBuilder();
						for (String columnName : interceptColumnNames) {
							Field field = paramClass.getDeclaredField(toHump(columnName));
							field.setAccessible(true);
							Object columnVal = field.get(paramObj);
							if(null != columnVal) {
								perpareMacStr.append(columnVal);
							}
						}
						String macStr = "";
						if(null != perpareMacStr && StringUtils.isNotBlank(perpareMacStr.toString())) {
							perpareMacStr.append(tableColumnConfig.getSalt());
							macStr = DigestUtils.md5DigestAsHex(perpareMacStr.toString().getBytes());
							paramClass.getSuperclass().getDeclaredMethod("setFdataversion", Integer.class).invoke(paramObj, 1);
							paramClass.getSuperclass().getDeclaredMethod("setFmacversion", Integer.class).invoke(paramObj, 1);
							paramClass.getSuperclass().getDeclaredMethod("setFmac", String.class).invoke(paramObj, macStr);

							return invocation.proceed();
						} else {
							// todo
							return false;
						}
					} else if (SqlCommandType.UPDATE == sqlCommandType) {
						Update updateSql = (Update) CCJSqlParserUtil.parse(sql.getSql());
						String whereStatement = "";
						Expression whereExp = updateSql.getWhere();
						List<Object> params = null;
						if(null != whereExp) {
							whereStatement = whereExp.toString();

							CharSequence charSequence = sql.getSql().substring(0, sql.getSql().indexOf("where"));
							int startIndex = StringUtils.countMatches(charSequence, "?");

							int total = StringUtils.countMatches(sql.getSql(), "?");
							params = new ArrayList<>();
							for (int i = startIndex; i < total; i++) {
								if (paramClass.getSimpleName().toLowerCase().contains("map")) {
									Map<String,Object> parmMap = (Map<String, Object>) paramObj;
									params.add(parmMap.get(sql.getParameterMappings().get(i).getProperty()));
								}else {
									Field field = paramClass.getDeclaredField(sql.getParameterMappings().get(i).getProperty());
									field.setAccessible(true);
									params.add(field.get(paramObj));
								}
							}
						}
						List<Map<String, Object>> objs = jdbcTemplate.queryForList("select * from " + tableName + " where " + whereStatement, params.toArray());

						if(CollectionUtils.isEmpty(objs)) {
							return invocation.proceed();
						} else {
							Map<String, Object> resultMap = (Map<String, Object>) objs.get(0);
							Object id = resultMap.get("id");
							StringBuilder orgMacBuilder = new StringBuilder();
							StringBuilder newMacBuilder = new StringBuilder();
							for (String columnName : interceptColumnNames) {
								Object val = resultMap.get(columnName);
								if (null != val) {
									orgMacBuilder.append(val);
								}
								if (paramClass.getSimpleName().toLowerCase().contains("map")) {
									Map<String,Object> parmMap = (Map<String, Object>) paramObj;
									Object newVal = parmMap.get(columnName);
									if (null != newVal) {
										newMacBuilder.append(newVal);
									}
								}else {
									Field field = paramClass.getDeclaredField(columnName);
									field.setAccessible(true);
									Object newVal = field.get(paramObj);
									if (null != newVal) {
										newMacBuilder.append(newVal);
									}
								}
							}
							if (null != orgMacBuilder) {
								orgMacBuilder.append(tableColumnConfig.getSalt());
								String orgMac = (String) resultMap.get("fmac");
								if (orgMac.equals(DigestUtils.md5DigestAsHex(orgMacBuilder.toString().getBytes()))) {
									newMacBuilder.append(tableColumnConfig.getSalt());
									String newMacStr = DigestUtils.md5DigestAsHex(newMacBuilder.toString().getBytes());
									Integer dataVersion = (Integer) resultMap.get("FDataVersion");
//									paramClass.getMethod("setFdataversion", Integer.class).invoke(paramObj, dataVersion + 1);
//									paramClass.getMethod("setFmac", String.class).invoke(paramObj, newMacStr);
									// 应判断当前数据版本号大于数据库中实际版本号才更新
									/**
									 * 重新初始化一个BoundSql，sql为改变后的再重新放入一个新的statement对象
									 */
									Object proceed = invocation.proceed();
									if (proceed instanceof Integer) {
										Integer result = (Integer) proceed;
										if (result > 0){
											String updatesql = "update "+ tableName +" set FDataVersion=1,FMacVersion="+(dataVersion + 1)+",FMac= '"+newMacStr+"' where id = '" + id +"';";
											jdbcTemplate.update(updatesql);
										}
									}
									return proceed;
								} else {
									// todo
									System.out.println("校验码不一致");
									return false;
								}
							}
						}
					}
				} else {
					return invocation.proceed();
				}
			} else {
				return invocation.proceed();
			}
		}
		return false;
	}

	private String toHump(String column) {
		String result = column;
		if(result.contains("_")) {
			StringBuilder keyTmp = new StringBuilder();
			String[] keyWords = column.split("_");
			for (int i = 0; i < keyWords.length; i++) {
				if (i == 0) {
					keyTmp.append(keyWords[i].toLowerCase(Locale.ENGLISH));
				} else {
					keyTmp.append(StringUtils.capitalize(keyWords[i].toLowerCase(Locale.ENGLISH)));
				}
			}
			result = String.valueOf(keyTmp);
		}
		return result;
	}

	private List<String> getTableNames(String sql) {
		Statement statement = null;
		try {
			statement = CCJSqlParserUtil.parse(sql);
		} catch (JSQLParserException e) {
			e.printStackTrace();
		}
		TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();

		return tablesNamesFinder.getTableList(statement);
	}


	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {

	}
}


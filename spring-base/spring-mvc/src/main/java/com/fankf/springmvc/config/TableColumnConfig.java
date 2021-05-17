package com.fankf.springmvc.config;

import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.*;

/**
 * 所有的要添加的防篡改配置类
 */
@Configuration
public class TableColumnConfig {
    private static Properties properties = null;
    /**
     * 进行计算的盐
     */
    private String salt = "123456";

    static {
        try {
            InputStream resourceAsStream = TableColumnConfig.class.getResourceAsStream("/tableColumn.properties");
            properties = new Properties();
            properties.load(resourceAsStream);
            System.out.println(properties.getProperty("fp_kj_log"));
        }catch (Exception e) {

        }
    }

    /**
     * 获取所有的要处理的表名
     * @return
     */
    public List<String> getAllTableNames(){
        Set<Object> objects = properties.keySet();
        ArrayList<String> tableNames = new ArrayList<>();
        objects.forEach(e ->{
            tableNames.add((String) e);
        });
        return tableNames;
    }

    /**
     * 获取配置的盐
     * @return
     */
    public String getSalt(){
        return salt;
    }

    /**
     * 获取所有要处理的字段值
     * @param tableName
     * @return
     */
    public List<String> getAllColumns(String tableName) {
        if (properties == null) {
            return null;
        }
        String property = properties.getProperty(tableName);
        if (property != null) {
            return new ArrayList<>(Arrays.asList(property.split(",")));
        }
        return new ArrayList<>();
    }

}

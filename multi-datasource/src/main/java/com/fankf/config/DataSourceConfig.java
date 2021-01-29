package com.fankf.config;

import com.fankf.enums.DataSourceEnum;
import com.fankf.model.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * fankunfeng
 * 2021-01-28 13:56
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "s0")
    @Primary
    @ConfigurationProperties(prefix = "spring.s0.datasource")
    public DataSource dataSource0(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "s1")
    @ConfigurationProperties(prefix = "spring.s1.datasource")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamic")
    public DynamicDataSource dynamicDataSource(@Qualifier("s0") DataSource dataSource0, @Qualifier("s1") DataSource dataSource1){
        Map<Object,Object> map = new HashMap<>(2);
        map.put(DataSourceEnum.S0,dataSource0);
        map.put(DataSourceEnum.S1,dataSource1);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(dataSource0);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamic")DynamicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 映射xml
        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}

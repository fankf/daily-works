package com.fankf.aop;

import com.fankf.enums.DataSourceEnum;
import com.fankf.model.DatabaseContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author fankunfeng
 * 2021-01-29 10:12
 */
@Component
@Aspect
public class DataSourceAspect {

    @Before("execution(* com.fankf.dao.s0.*.*(..))")
    public void dataSourceS0(){
        DatabaseContextHolder.setDataSource(DataSourceEnum.S0);
    }
    @Before("execution(* com.fankf.dao.s1.*.*(..))")
    public void dataSourceS1(){
        DatabaseContextHolder.setDataSource(DataSourceEnum.S1);
    }
}

package com.fankf.ioc.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * fankunfeng
 * 2020-09-07 19:30
 */
@Aspect
@Component
public class UserProxy {


    @Before(value = "pointcut()")
    public void before() {
        System.out.println("before ...");
    }

    @Pointcut(value = "execution(* com.fankf.ioc.bean.User.add(..))")
    public void pointcut() {
        System.out.println("before ...");
    }
}

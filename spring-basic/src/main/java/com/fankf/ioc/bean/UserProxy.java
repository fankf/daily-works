package com.fankf.ioc.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * fankunfeng
 * 2020-09-07 19:30
 */
@Aspect
@Component
public class UserProxy {

    @Before(value = "execution(* com.fankf.ioc.bean.User.add(..))")
    public void before(){
        System.out.println("before ...");
    }

    public void after(){
        System.out.println("before ...");
    }
}

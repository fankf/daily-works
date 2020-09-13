package com.fankf.aop.bean;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * fankunfeng
 * 2020-09-12 12:${MINURE}
 */
@Order(1)
@Component
@Aspect
public class User2Proxy {
    @Before(value = "execution(* com.fankf.aop.bean.User.add(..))")
    public void before(){
        System.out.println("before user2proxy ...");
    }
}

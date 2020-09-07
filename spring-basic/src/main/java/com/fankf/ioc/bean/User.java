package com.fankf.ioc.bean;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * fankunfeng
 * 2020-09-03 10:41
 */
@Component
public class User {

    public void add(){
        System.out.println(" add ......");
    }
}

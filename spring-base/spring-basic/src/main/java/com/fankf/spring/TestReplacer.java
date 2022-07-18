package com.fankf.spring;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author fans
 * @date 2022/6/30 16:50
 * @description
 */
public class TestReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("TestReplacer .........");

        return null;
    }
}

package com.fankf.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * fankunfeng
 * 2020-08-20 23:${MINURE}
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("method:" + method + "args:" + Arrays.asList(args));

        Object invoke = method.invoke(obj, args);

        System.out.println("invoke : " + invoke);

        return invoke;
    }
}

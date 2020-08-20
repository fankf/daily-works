package com.fankf.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * fankunfeng
 * 2020-08-20 23:${MINURE}
 */
public class MyProxy {
    public static void main(String[] args) {
        Class[] clazz = {UserService.class};
        UserServiceImpl service = new UserServiceImpl();
        UserService userService = (UserService) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), clazz, new MyInvocationHandler(service));
        userService.add(1,1);
    }
}

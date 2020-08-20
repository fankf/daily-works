package com.fankf.jdkproxy;

/**
 * fankunfeng
 * 2020-08-20 23:${MINURE}
 */
public class UserServiceImpl implements UserService {
    @Override
    public int add(int a, int b) {
        System.out.println("a :" + a + "b:" + b);
        return a + b;
    }

    @Override
    public String update(String str) {
        System.out.println("str :" + str);
        return str;
    }
}

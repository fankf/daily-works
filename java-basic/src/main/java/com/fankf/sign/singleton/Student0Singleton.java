package com.fankf.sign.singleton;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 14:18
 * @PACKAGE -> com.fankf.sign.singleton
 */
public class Student0Singleton {

    private static Student0Singleton var0 = new Student0Singleton();

    public static Student0Singleton student0Singleton() {
        return var0;
    }

    private Student0Singleton() {
    }

}

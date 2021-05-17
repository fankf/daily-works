package com.fankf.sign.singleton;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 14:18
 * @PACKAGE -> com.fankf.sign.singleton
 */
public class Student1Singleton {

    private static Student1Singleton var0;

    public static Student1Singleton student1Singleton() {
        synchronized (Student1Singleton.class) {
            if (var0 == null) {
                var0 = new Student1Singleton();
            }
            return var0;
        }
    }

    private Student1Singleton() {
    }
}

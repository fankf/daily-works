package com.fankf.sign.singleton;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 14:18
 * @PACKAGE -> com.fankf.sign.singleton
 */
public class Student2Singleton {

    private static Student2Singleton var0;

    public static class Singleton {
        public static Student2Singleton instance() {
            if (var0 == null) {
                var0 = new Student2Singleton();
            }
            return var0;
        }
    }

    private Student2Singleton() {
    }

}

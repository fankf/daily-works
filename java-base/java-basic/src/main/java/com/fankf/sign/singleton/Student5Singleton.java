package com.fankf.sign.singleton;

/**
 * fankunfeng
 * 2020-09-07 09:28
 */
public class Student5Singleton {
    private static volatile Student5Singleton singleton;

    private Student5Singleton() {
    }


    public Student5Singleton instance() {
        if (singleton == null) {
            synchronized (Student5Singleton.class) {
                if (singleton == null) {
                    singleton = new Student5Singleton();
                }
            }
        }
        return singleton;


    }
}
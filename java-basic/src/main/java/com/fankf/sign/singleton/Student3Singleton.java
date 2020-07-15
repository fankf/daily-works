package com.fankf.sign.singleton;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 14:18
 * @PACKAGE -> com.fankf.sign.singleton
 */
public enum Student3Singleton {
    INSTANCE;

    private Student3Singleton() {

    }

    public Student3Singleton instance() {
        return INSTANCE;
    }
}

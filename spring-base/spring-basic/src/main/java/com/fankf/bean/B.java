package com.fankf.bean;

/**
 * @author fans
 * @date 2022/7/21 10:15
 * @description
 */
public class B {

    private C c;

    public B() {
        System.out.println("B() ...");
    }
    public B(C c) {
        System.out.println("B(C c) ...");
        this.c = c;
    }

    public C getC() {
        System.out.println("getC() ...");
        return c;
    }

    public void setC(C c) {
        System.out.println("setC(C c) ...");
        this.c = c;
    }
}

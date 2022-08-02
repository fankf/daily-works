package com.fankf.bean;

/**
 * @author fans
 * @date 2022/7/21 10:15
 * @description
 */
public class A {

    private B b;

    public A() {
        System.out.println("A() ...");
    }

    public A(B b) {
        System.out.println("A(B b) ...");
        this.b = b;
    }

    public B getB() {
        System.out.println("getB() ...");
        return b;
    }

    public void setB(B b) {
        System.out.println("setB(B b) ...");
        this.b = b;
    }
}

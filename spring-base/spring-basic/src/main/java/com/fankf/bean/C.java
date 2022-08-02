package com.fankf.bean;

/**
 * @author fans
 * @date 2022/7/21 10:15
 * @description
 */
public class C {
    private A a;

    public C() {
        System.out.println("C() ...");
    }
    public C(A a){
        System.out.println("C(A a) ...");
        this.a = a;
    }

    public A getA() {
        System.out.println("getA() ...");
        return a;
    }

    public void setA(A a) {
        System.out.println("setA(A a) ...");
        this.a = a;
    }
}

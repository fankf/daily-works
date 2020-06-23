package com.fankf.java8;

public class Java8Test {

    public static void main(String[] args) {
        int a = 9;
        a = a++ / 2; //先计算÷
        System.out.println(a);
        a = ++a * 2; //先计算 +
        System.out.println(a);
    }
}

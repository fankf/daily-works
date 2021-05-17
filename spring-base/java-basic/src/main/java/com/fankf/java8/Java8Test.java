package com.fankf.java8;

import java.util.Arrays;
import java.util.List;

public class Java8Test {

    public static void main(String[] args) {
        int a = 9;
        a = a++ / 2; //先计算÷
        System.out.println(a);
        a = ++a * 2; //先计算 +
        System.out.println(a);


        List<String> strings = Arrays.asList("1", "2");
        System.out.println(strings.stream().noneMatch(o -> "2".equals(o)));
        System.out.println(strings.stream().noneMatch("3"::equals));
    }
}

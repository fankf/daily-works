package com.fankf.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ArraysTest {
    public static void main(String[] args) {
        int[] t = {1, 11, 3, 4};
        // 适配器模式 asList
        List<int[]> ints = Arrays.asList(t);

        // equals
        boolean equals = Arrays.equals(t, t);

        // steams
        IntStream stream = Arrays.stream(t);

        //sort
        Arrays.sort(t);
        Arrays.stream(t).forEach(a -> System.out.print(a + " "));
        System.out.println();

        String[] s = {"123", "aA", "DD", "Kz"};
        Arrays.sort(s,1,3);
        Arrays.stream(s).forEach(a -> System.out.print(a + " "));
        // 比较器排序
        Arrays.sort(s, String::compareTo);
        Arrays.stream(s).forEach(a -> System.out.print(a + " "));
        System.out.println();


    }
}

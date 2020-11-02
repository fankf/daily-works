package com.fankf.mooc;

/**
 * fankunfeng
 * 2020-11-02 20:32
 *  打印 1-N
 */
public class PrintN {
    private static void print(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(i+" ");
        }
    }
    private static void print2(int n){
        if(n != 0){
            System.out.print(n+" ");
            print2(n-1);
        }
    }

    public static void main(String[] args) {
//        test(100);
//        test(1000);
        test(10000);

    }

    public static void test(int n) {
        long start = System.currentTimeMillis();
        print(n);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end-start);
        long start1 = System.currentTimeMillis();
        print2(n);
        long end1 = System.currentTimeMillis();
        System.out.println();
        System.out.println(end1-start1);
    }
}

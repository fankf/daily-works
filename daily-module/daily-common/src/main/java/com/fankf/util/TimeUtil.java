package com.fankf.util;

/**
 * @author fankf
 * @date 2021/5/21 10:18
 * @description
 */
public class TimeUtil {
    private volatile static ThreadLocal<Long> local = new ThreadLocal<>();

    public static void start() {
        local.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - local.get();
    }

    public static void main(String[] args) throws InterruptedException {
        start();
        Thread.sleep(1000);
        long end = end();

        System.out.println(end);
    }
}

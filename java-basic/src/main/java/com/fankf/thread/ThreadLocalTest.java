package com.fankf.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * fankunfeng
 * 2020-10-26 15:30
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(1);
        cyclicBarrier.wait();
        Thread10 thread10 = new Thread10();
        Thread11 thread11 = new Thread11();
        thread10.start();
        thread11.start();
    }

    static class Thread10 extends Thread {
        @Override
        public void run() {
            System.out.println("before Thread10 : threadLocal " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 1);
            System.out.println("after Thread10 : threadLocal " + threadLocal.get());
        }
    }

    static class Thread11 extends Thread {
        @Override
        public void run() {
            System.out.println("===before Thread11 : threadLocal " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 1);
            System.out.println("===after Thread11 : threadLocal " + threadLocal.get());
        }
    }
}

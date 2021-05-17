package com.fankf.thread;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class CyclicBarrierTest {

    private static CyclicBarrier barrier = new CyclicBarrier(5, new MyBarrier2());

    private static Executor executor = Executors.newFixedThreadPool(5);
    private static ConcurrentHashMap<String, Thread> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        MyBarrier m1 = new MyBarrier();
        MyBarrier m2 = new MyBarrier();
        MyBarrier m3 = new MyBarrier();
        MyBarrier m4 = new MyBarrier();
        MyBarrier m5 = new MyBarrier();
        executor.execute(m1);
        executor.execute(m2);
        executor.execute(m3);
        executor.execute(m4);
        executor.execute(m5);

    }

    private static class MyBarrier extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---------------");
            concurrentHashMap.put(Thread.currentThread().getName(), Thread.currentThread());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "====---------------");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyBarrier2 extends Thread {

        @Override
        public void run() {
            System.out.println("    private static class MyBarrier2 extends Thread ---------------");
            ConcurrentHashMap.KeySetView<String, Thread> strings = concurrentHashMap.keySet();
            String join = String.join(",", strings);
            System.out.println("reduce : " + join);
            System.out.println("-----------------------reduce end ---------------");


            System.out.println("    private static class MyBarrier2 extends Thread ---------------");

        }
    }
}

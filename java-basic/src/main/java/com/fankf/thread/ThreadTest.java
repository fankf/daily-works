package com.fankf.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread0 thread0 = new Thread0();
        thread0.start();
        thread0.suspend();
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis());
        thread0.resume();
        thread0.interrupt();
        Thread1 thread1 = new Thread1();
        thread1.start();
        System.out.println(System.currentTimeMillis());
//        thread1.interrupt();
        TimeUnit.SECONDS.sleep(1);

        thread1.cannal();
//        thread1.stop();
//        System.out.println(System.currentTimeMillis());
    }

    static class Thread0 extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("当前线程的状态："+isInterrupted());
            while (!isInterrupted()){
                System.out.println("当前线程的状态："+isInterrupted());
                System.out.println("Thread0  interrupt...");
            }
            System.out.println("当前线程的状态："+isInterrupted());
            System.out.println("Thread0 ...");
        }
    }


    static class Thread1 extends Thread{
        private volatile boolean on = true ;
        private long i = 0 ;
        @SneakyThrows
        @Override
        public void run() {
//            System.out.println("Thread1 ...");
//            Thread.sleep(1000);
            System.out.println("Thread1 ..." + interrupted());
            while ( on && !Thread.currentThread().interrupted()){
                i++ ;
            }
            System.out.println("==========" + i  + " ==" + interrupted());
        }

        public void cannal(){
            on = false;
        }
    }
}

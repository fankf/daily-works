package com.fankf.thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread0 thread0 = new Thread0();
        thread0.start();
        Thread.sleep(1000);
        thread0.interrupt();
        Thread1 thread1 = new Thread1();
        thread1.start();
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
        @Override
        public void run() {
            super.run();
            System.out.println("Thread1 ...");
        }
    }
}

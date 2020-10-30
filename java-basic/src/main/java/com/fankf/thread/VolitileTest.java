package com.fankf.thread;

/**
 * fankunfeng
 * 2020-10-26 15:30
 */
public class VolitileTest {

    private volatile int i = 0;

    public static void main(String[] args) {

    }


    public void add() {
        i++;
    }

    public void sub() {
        i--;
    }

    public class Thread0 implements Runnable {


        @Override
        public void run() {
            add();
        }
    }

    public class Thread1 implements Runnable {

        @Override
        public void run() {
            sub();
        }
    }
}

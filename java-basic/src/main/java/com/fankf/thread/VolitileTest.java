package com.fankf.thread;

/**
 * fankunfeng
 * 2020-10-26 15:30
 */
public class VolitileTest {

    private static  int i = 0;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        VolitileTest.i = i;
    }

    public void add() {
        i++;
    }

    public void sub() {
        --i;
    }

    public final class Thread0 implements Runnable {


        @Override
        public void run() {
            add();
            System.out.println(i);
        }
    }

    public final class Thread1 implements Runnable {

        @Override
        public void run() {
            sub();
            System.out.println(i);
        }
    }
}

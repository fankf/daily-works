package com.fankf.thread;

/**
 * fankunfeng
 * 2020-10-26 15:30
 */
public class VolitileTest {

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            new Thread(new Thread0()).start();
            new Thread(new Thread1()).start();
        }
        System.out.println(i);
    }

    public static VolitileTest volitileTest = new VolitileTest();
    private static int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        VolitileTest.i = i;
    }

    public void add() {
        i++;
    }

    public void sub() {
        --i;
    }

    public static class Thread0 implements Runnable {


        @Override
        public void run() {
            volitileTest.add();
//            System.out.println(i);
        }
    }

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            volitileTest.sub();
//            System.out.println(i);
        }
    }
}

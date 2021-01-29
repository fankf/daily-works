package com.fankf.thread;

import lombok.SneakyThrows;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer invoke = forkJoinPool.invoke(new MyRecursiveTask(1, 10000));
        try {
            System.out.println(invoke);
        } catch ( Exception e){

        }
    }

    private static class MyRecursiveTask extends RecursiveTask<Integer> {
        public static final int KEY = 2;
        private long start;
        private long end;

        MyRecursiveTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @SneakyThrows
        @Override
        protected Integer compute() {
            int sum = 0;
            boolean flag = (end - start) <= KEY;
            if (flag) {
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                long mid = (start + end) / 2;
                MyRecursiveTask m1 = new MyRecursiveTask(start, mid);
                MyRecursiveTask m2 = new MyRecursiveTask(mid + 1, end);
                ForkJoinTask<Integer> fork = m1.fork();
                Integer integer1 = fork.get();
                ForkJoinTask<Integer> fork1 = m2.fork();
                Integer integer = fork1.get();
                System.out.println(integer + "==="+integer1);
                return m1.join() + m2.join();
            }
            return sum;
        }
    }
}


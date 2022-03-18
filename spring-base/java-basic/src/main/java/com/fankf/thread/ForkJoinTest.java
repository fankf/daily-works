package com.fankf.thread;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MyRecursiveAction(1, 100));

//        Integer invoke = forkJoinPool.invoke(new MyRecursiveTask(1, 10000));
//        try {
//            System.out.println(invoke);
//        } catch ( Exception e){
//
//        }
    }



    private static class MyRecursiveAction extends RecursiveAction {
        public static final int KEY = 2;
        private long start;
        private long end;

        MyRecursiveAction(long start, long end) {
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            boolean flag = (end - start) <= KEY;
            if (flag) {
                System.out.println("action"+Thread.currentThread().getName());
            } else {
                long mid = (start + end) / 2;
                System.out.println(start + "-"+ end +"-"+mid);
                MyRecursiveAction m1 = new MyRecursiveAction(start, mid);
                MyRecursiveAction m2 = new MyRecursiveAction(mid + 1, end);
                ForkJoinTask<Void> fork = m1.fork();
                ForkJoinTask<Void> fork1 = m2.fork();
            }
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
                Integer integer1 = null;
                try {
                    integer1 = fork.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                ForkJoinTask<Integer> fork1 = m2.fork();
                Integer integer = null;
                try {
                    integer = fork1.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(integer + "==="+integer1);
                return m1.join() + m2.join();
            }
            return sum;
        }
    }
}


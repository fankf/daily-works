package com.fankf.utils;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
//       cyclicBarrier();
       countDownlatch();
        semaphore();
    }

    private static void semaphore() {
        Semaphore semaphore = new Semaphore(10);
    }
    private static void countDownlatch() {
        ExecutorService executorService = new ThreadPoolExecutor(12, 12, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>()
                , new ThreadPoolExecutor.CallerRunsPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(30);
        System.out.println("开始执行===>"+LocalDateTime.now());
        for (int i = 0; i < 30; i++) {
            int pageNo = i;
            executorService.execute(() -> {
                try {
                    System.out.println(pageNo);
                    Thread.sleep(1000);
                    System.out.println(pageNo+"===>"+LocalDateTime.now());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end ===>"+LocalDateTime.now());
    }

    private static void cyclicBarrier() {
        ExecutorService executorService = new ThreadPoolExecutor(12, 12, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>()
                , new ThreadPoolExecutor.CallerRunsPolicy());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        System.out.println("开始执行===>"+LocalDateTime.now());
        for (int i = 0; i < 30; i++) {
            int pageNo = i;
            executorService.execute(() -> {
                try {
                    System.out.println(pageNo);
                    cyclicBarrier.await();
                    System.out.println(pageNo+"===>"+LocalDateTime.now());

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}


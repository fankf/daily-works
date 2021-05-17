package com.fankf.service.iml;

import com.fankf.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    public void test() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AsyncService ... Async");
    }

    @Async
    @Override
    public void test2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AsyncService ... Async2");
    }
}

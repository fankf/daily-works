package com.fankf.controller;

import com.fankf.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sync")
public class AsyncTestController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("")
    public String testAsync() throws InterruptedException {

        asyncService.test();
        asyncService.test2();
        System.out.println(".............AsyncTestController..........");
        Thread.sleep(3000);
        System.out.println(".............AsyncTestController2..........");
        return "result";
    }

}

package com.fankf.controller;

import com.fankf.api.TestSayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference
    private TestSayHelloService testSayHelloService;

    @RequestMapping("/")
    public String test() {
        return testSayHelloService.sayHello();
    }
}

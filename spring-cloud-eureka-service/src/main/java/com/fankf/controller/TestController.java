package com.fankf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "hello world!";
    }
}

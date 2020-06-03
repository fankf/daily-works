package com.fankf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {

    @Value("k")
    private String k;
    @RequestMapping("/sayHello2/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "hello world! hello2," + name;
    }

    @RequestMapping("/hi")
    public String sayhi() {
        return "hello world! hello2," + k;
    }
}

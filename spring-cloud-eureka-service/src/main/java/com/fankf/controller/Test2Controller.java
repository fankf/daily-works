package com.fankf.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {

    @RequestMapping("/sayHello2/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "hello world! hello2," + name;
    }
}

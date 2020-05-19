package com.fankf.controller;

import com.fankf.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignController {
    @Autowired
    private FeignService feignService;

    @RequestMapping("/hi")
    public String sayHello() {
        return feignService.sayHello("xxx");
    }
}

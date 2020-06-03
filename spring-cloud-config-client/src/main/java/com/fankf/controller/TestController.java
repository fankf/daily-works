package com.fankf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${k}")
    private String k;

    @RequestMapping("/")
    public String getConfig() {
        return "hello," + k;
    }
}

package com.fankf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sleuth")
public class TestController {

    @RequestMapping("")
    public String sleuth() {
        return "hello sleuth";
    }
}

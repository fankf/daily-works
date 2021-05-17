package com.fankf.controller;

import com.fankf.rest.TestRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    private TestRestService testRestService;

    @RequestMapping("/test")
    public String testRest() {
        return testRestService.sayhello("ZZZ");
    }
}

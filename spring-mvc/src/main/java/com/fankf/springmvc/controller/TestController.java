package com.fankf.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestController {

    @GetMapping(value = "/get/{name}")
    public String getMappingTest(@PathVariable(value = "name") String name) {
        log.info("TestController getMappingTest ...");
        return name;
    }

    @PutMapping(value = "/put")
    public String putMappingTest(@RequestBody String name) {
        return name;
    }

    @PostMapping(value = "/post")
    public String postMappingTest(@RequestBody String name) {
        return name;
    }

    @DeleteMapping(value = "/delete")
    public String deleteMappingTest(@RequestBody String name) {
        return name;
    }

    @RequestMapping(value = "/delete")
    public String mappingTest(@RequestParam(value = "name") String name) {
        return name;
    }
}

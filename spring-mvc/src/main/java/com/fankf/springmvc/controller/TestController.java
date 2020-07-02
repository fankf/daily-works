package com.fankf.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

@RestController
@Slf4j
//@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/get/{name}")
    public String getMappingTest(@PathVariable(value = "name") String name) {
        log.info("TestController getMappingTest ... name :{} ", name);
        return name;
    }

    @PutMapping(value = "/put")
    public String putMappingTest(@RequestBody String name) {
        return name;
    }

    @PostMapping(value = "/post")
    public String postMappingTest(HttpServletRequest request, @RequestBody String name) {
        String decode = URLDecoder.decode(name);
        log.info("TestController getMappingTest ... name :{} ", decode);
        return decode;
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

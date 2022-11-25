package com.fankf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DailyStartNacosConfigApplication {

    @Value("${uaa}")
    private String username;

    public static void main(String[] args) {
        SpringApplication.run(DailyStartNacosConfigApplication.class, args);


    }

    @GetMapping("/test")
    String test(){
        System.out.println(username);
        return username;
    }

}

package com.fankf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyStartNacosConfigApplication {

    @Value("${username}")
    private static String username;

    public static void main(String[] args) {
        SpringApplication.run(DailyStartNacosConfigApplication.class, args);

        System.out.println(username);
    }

}

package com.fankf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringMycatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMycatApplication.class, args);
    }

    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

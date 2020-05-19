package com.fankf.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class TestRestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String sayhello(String name) {
        String url = "http://order-server/sayHello/";
        return restTemplate.getForObject(url + name, String.class);
    }

    public String helloError(String name) {
        return "hello error" + name;
    }
}

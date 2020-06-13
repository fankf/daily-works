package com.fankf.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestRestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError3")
    public String sayhello(String name) {
        String url = "http://order-server/sayHello0/";
        String forObject = restTemplate.getForObject(url + name, String.class);
        return forObject;
    }

//    @HystrixCommand(fallbackMethod = "helloError2")
    public String helloError(String name) {
        String url = "http://order-server/sayHello1/";
        String forObject = restTemplate.getForObject(url + name, String.class);
        return forObject;
    }

    @HystrixCommand(fallbackMethod = "helloError3")
    public String helloError2(String name) {
        String url = "http://127.0.0.1:11000/get/a";
        String forObject = restTemplate.getForObject(url + name, String.class);
        return forObject;
    }

    public String helloError3(String name) {
        return "hello error" + name;
    }
}

package com.fankf.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestRestService {
    @Autowired
    private RestTemplate restTemplate;

    public String sayhello(String name) {
        String url = "http://order-server/sayHello/";
        return restTemplate.getForObject(url + name, String.class);
    }
}

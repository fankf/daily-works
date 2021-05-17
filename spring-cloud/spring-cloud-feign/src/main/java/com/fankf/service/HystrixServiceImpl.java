package com.fankf.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixServiceImpl implements FeignService {
    @Override
    public String sayHello(String name) {
        return "hello error" + name;
    }
}

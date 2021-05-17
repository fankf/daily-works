package com.fankf.service;

import com.fankf.api.TestSayHelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestSayHelloServiceImpl implements TestSayHelloService {
    @Override
    public String sayHello() {
        return "say hello";
    }
}

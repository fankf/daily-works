package com.fankf.nacos.serivce.impl;

import com.fankf.api.TestSayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author fankf
 * @date 2021/5/19 14:09
 * @description
 */
@DubboService
public class TestServiceImpl implements TestSayHelloService {
    @Override
    public String sayHello() {
        return "hello nacos !";
    }
}

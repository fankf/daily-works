package com.fankf.nacos.controller;

import com.alibaba.fastjson.JSON;
import com.fankf.api.TestSayHelloService;
import evisionos.mplat.auth.api.AuthServiceApi;
import evisionos.mplat.common.core.bean.R;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author fankf
 * @date 2021/5/19 14:11
 * @description
 */
@RestController
public class TestController {

    @DubboReference
    TestSayHelloService testSayHelloService;

    @GetMapping("/hello")
    public String sayHello(){
        return testSayHelloService.sayHello();
    }
}

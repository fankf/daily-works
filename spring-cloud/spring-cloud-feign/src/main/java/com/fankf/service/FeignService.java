package com.fankf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "order-server",fallback = HystrixServiceImpl.class)
public interface FeignService {

    @RequestMapping(value = "/sayHello/{name}")
    String sayHello(@PathVariable(value = "name") String name);
}

package com.fankf.demo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.client.naming.NacosNamingService;
import com.alibaba.nacos.client.naming.utils.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Properties;

/**
 * @author fankf
 * @date 2021/5/18 17:36
 * @description
 */
@RestController
public class ConsumerController {

//    @NacosInjected
//    NacosNamingService nacosNamingService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 检查所有的服务
     * @return
     */
    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        return provider;
    }

    @GetMapping("/index")
    public String index(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        int index = ThreadLocalRandom.current().nextInt(provider.size());
        String url = provider.get(index).getUri()+"/index";
        return "consumer随机远程调用provier："+this.restTemplate.getForObject(url, String.class);
    }



}

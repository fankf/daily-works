package com.fankf.nacos;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboNacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboNacosProviderApplication.class, args);
    }

}

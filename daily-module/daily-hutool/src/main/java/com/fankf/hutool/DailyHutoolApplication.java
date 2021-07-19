package com.fankf.hutool;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.Map;

@SpringBootApplication
public class DailyHutoolApplication {

    private static final Logger log = LoggerFactory.getLogger(DailyHutoolApplication.class);

    @Value("test")
    private String test;

    public static void main(String[] args) {
        SpringApplication.run(DailyHutoolApplication.class, args);
        Map<String, String> getenv = System.getenv();
//        String test = System.getProperty("test");
        log.info(JSONUtil.toJsonStr(getenv));
        DailyHutoolApplication app = new DailyHutoolApplication();
        app.test();
        URL resource = app.getClass().getResource("application.yml");
        System.out.println(resource);

    }


    public void test(){
        System.out.println(test);
    }
}

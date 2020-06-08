package com.fankf.springmvc.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HttpTest {

    public static final String URI = "http://localhost:8081/order-api/weixin";
    @Autowired
    RestTemplate template;

    @RequestMapping("/wx")
    public void getWeixinInfo() {
        ResponseEntity<String> stringResponseEntity = template.postForEntity(URI, null, String.class);
        System.out.println(stringResponseEntity);
    }
}

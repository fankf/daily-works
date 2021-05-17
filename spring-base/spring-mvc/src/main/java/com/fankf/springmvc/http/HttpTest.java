package com.fankf.springmvc.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HttpTest {

    public static final String URI = "http://localhost:8081/order-api/weixin";
    public static final String URIS = "http://localhost:8081/order-api/weixin,http://localhost:8081/order-api/weixin0,http://localhost:8081/order-api/weixin1";

    @Qualifier("rest")
    @Autowired
    RestTemplate template;

    @RequestMapping("/wx")
    public void getWeixinInfo() {
        ResponseEntity<String> stringResponseEntity = template.postForEntity(URI, null, String.class);
        System.out.println(stringResponseEntity);
    }
}

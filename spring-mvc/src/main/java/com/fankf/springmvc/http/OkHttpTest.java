package com.fankf.springmvc.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ok")
public class OkHttpTest {
    @Value("#{'${okHttp.urls}'.split(',')[0]}")
    public static String URI;

    @Qualifier("okhttp3")
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("")
    public String okHttpTest() {
        String object = restTemplate.postForObject(URI, null, String.class);
        return object;
    }

    @RequestMapping("t")
    public String okHttpTestt() {
        String object = restTemplate.postForObject(URI, null, String.class);
        return object;
    }

    public static void main(String[] args) throws URISyntaxException {
        String url0 = "http://localhost:9090/a/a/a";
        String url1 = "http://localhost:9999";
        List<String> ipPort0 = Arrays.stream(url0.split("\\/")).filter(s -> s.contains(":")).collect(Collectors.toList());
        List<String> ipPort1 = Arrays.stream(url1.split("\\/")).filter(s -> s.contains(":")).collect(Collectors.toList());

        System.out.println(url0.replace(ipPort0.get(1), ipPort1.get(1)));


    }
}

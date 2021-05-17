//package com.fankf.springmvc.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//@Slf4j
//@WebFilter
//@Component
//public class WeixinFilter extends HttpFilter {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//    @Override
//    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String requestURL = request.getRequestURL().toString();
//        log.info("request url : " + requestURL);
//        // 1. 请求微信
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        //cookie
//
//        Cookie[] cookies = request.getCookies();
//        List<String> cookieList = new ArrayList<>();
//        for (Cookie cookie : cookies) {
//            cookieList.add(cookie.getName() + "=" + cookie.getValue());
//        }
//        //组装参数
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.put(HttpHeaders.COOKIE, cookieList);
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(null, httpHeaders);
//        String url = "https://pay.weixin.qq.com/index.php/xphp/cinvoicing/checkdxhysession?ishttp=1";
//
//        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
//        HttpStatus statusCode = result.getStatusCode();
//        if(statusCode.value() != 200){
//            log.error("请求数据未成功，状态码：{},结果信息：{}",statusCode.value(),statusCode.getReasonPhrase());
//        }
//        //2.放入redis
//        super.doFilter(request, response, chain);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
//

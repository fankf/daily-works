package com.fankf;

import com.fankf.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * fankunfeng
 * 2020-09-16 23:07
 */
public class Client {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://127.0.0.1:52195");
        User user = webClient.get().uri("/user/1").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(user.getUsername());
    }
}

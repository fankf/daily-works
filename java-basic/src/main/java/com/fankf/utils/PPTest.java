package com.fankf.utils;

import org.springframework.util.AntPathMatcher;

public class PPTest {
    public static void main(String[] args) {
        AntPathMatcher api = new AntPathMatcher();

        boolean match = api.match("/kafkaa/**", "/kafka/a/a/你好");
        System.out.println(match);
    }
}

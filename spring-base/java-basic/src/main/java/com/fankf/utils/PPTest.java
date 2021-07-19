package com.fankf.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.AntPathMatcher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PPTest {

    /**
     *
     * @param args
     * @throws FileNotFoundException 文档未找到
     */
    public static void main(String[] args){


        File file = new File("");
        try {
            InputStream inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {

        }

        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(JSON.toJSONString(list));
        list.clear();
        System.out.println(JSON.toJSONString(list));

        AntPathMatcher api = new AntPathMatcher();

        boolean match = api.match("/kafkaa/**", "/kafka/a/a/你好");
        System.out.println(match);
    }
}

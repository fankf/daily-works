package com.fankf.json.fastjson;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fankunfeng
 * 2021-04-20 18:08
 */
public class JSONTest {
    public static void main(String[] args) {
//        String s = "{\n" +
//                "\t\"xhfNsrsbh\":\"1232131\",\n" +
//                "\t\"num\":5000\n" +
//                "}";
        String s = "{}";
        JSONObject jsonObject = JSONObject.parseObject(s);

        Integer num = 5000;
        if(jsonObject.get("num") == null){
            Object num1 = jsonObject.get("num");
            if(num1 instanceof Integer){
                num = (Integer) num1;
            }
        }

        Set<String> collect = new HashSet<>();
        if(jsonObject.get("xhfNsrsbh") != null){
            collect.add((String) jsonObject.get("xhfNsrsbh"));
        }

        System.out.println(num);
        System.out.println(collect.iterator().next());
    }
}

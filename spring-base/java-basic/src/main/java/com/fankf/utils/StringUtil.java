package com.fankf.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fans
 * @date 2022/8/4 17:56
 * @description
 */
public class StringUtil {
    public static void main(String[] args) {

        String[] strs = {"a", "b", "c"};
        StringBuilder resultStr = new StringBuilder();
        for (String str : strs) {
            resultStr.append(str).append(",");
        }
        System.out.println(resultStr.substring(0,resultStr.length()-1));
        // 数组
        System.out.println(String.join(",", "a","b","c"));
        System.out.println(String.join(",", strs));
        // 集合
        List<String> strlist = Arrays.asList(strs);
        System.out.println(String.join(",", strlist));

        // json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","aValue");
        jsonObject.put("b","bValue");
        jsonObject.put("c","cValue");
        System.out.println(String.join(",", jsonObject.keySet()));
        // 不可以
//        System.out.println(String.join(",", jsonObject.values()));
        Map<String,Object> map = new HashMap<>();
        map.put("ak","aMapValue");
        map.put("bk","bMapValue");
        map.put("ck","cMapValue");
        System.out.println(String.join(",", map.keySet()));
//        System.out.println(String.join(",", map.values()));

        Map<String,String> map2 = new HashMap<>();
        map2.put("ak","aMapValue");
        map2.put("bk","bMapValue");
        map2.put("ck","cMapValue");
        System.out.println(String.join(",", map2.keySet()));
        System.out.println(String.join(",", map2.values()));


        // stream
        System.out.println(Arrays.stream(strs).collect(Collectors.joining(",")));
        System.out.println(strlist.stream().collect(Collectors.joining(",")));
        System.out.println(jsonObject.values().stream().map(String::valueOf).collect(Collectors.joining(",")));

        int[] ints = {1,2,3};
        System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        // 其他字符
        System.out.println(String.join("我真菜", strs));

        Map<String, Object> map3 = new HashMap<>();
        Map<String, Object> map4 = new HashMap<>();
        map4.put("x","x");
        map4.put("z","z");
        map3.put("y", map4);
        System.out.println(map3.values().stream()
                .map(o -> ((Map<String, Object>)o).values())
                .map(String::valueOf)
                .collect(Collectors.joining(",")));

        // POJO对象

        User user1 = new User(1, "zhangsan");
        User user2 = new User(2, "lisi");
        List<User> users = Arrays.asList(user1, user2);
        System.out.println(users.stream().map(User::getName).collect(Collectors.joining(",")));

        user2 = null;
        System.out.println(Optional.ofNullable(user2).map(o -> o.getName()).orElse("zzz"));

        String z = null;
        String a = "a";

        List<String> array = new ArrayList<>();
        CollectionUtils.addIgnoreNull(array,z);
        CollectionUtils.addIgnoreNull(array,a);
        System.out.println(String.join("==",array));
    }

    @Data
    @AllArgsConstructor
    private static class User{
        private int id;
        private String name;
    }
}



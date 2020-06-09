package com.fankf.java8;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 使用stream
 */
public class Java8StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("13");
        list.add("1");
        list.add("11");
        list.add("11");
        list.add("14");

        List<User> users = new ArrayList<>();
        users.add(new User(12, "X"));
        users.add(new User(2, "X1"));
        users.add(new User(22, "X3"));
        users.add(new User(6, "X4"));
        users.add(new User(14, "X6"));
        //1. 过滤 1 的字符串 filter
        System.out.println(JSON.toJSONString(list));
        List<String> collect = list.stream().filter(string -> !"1".equals(string)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        //2. 保留 过滤的条件 filter
        collect = list.stream().filter(string -> "2".equals(string)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        List<User> users2 = users.stream().filter(user -> 2 == user.getAge()).collect(Collectors.toList());
        System.out.println("==>" + JSON.toJSONString(users2));

        //3. 过滤重复 distict
        collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        //4. sorted
        collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        // sort((T1,T2) -> t1 compare t2) 或者 Comparator.comparingInt(Class:methed)
        List<User> userList = users.stream().sorted((u1, u2) -> u1.getAge() - u2.getAge()).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSONString(userList));
        userList = users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSONString(userList));
        //5. limit
        collect = list.stream().limit(2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        //6. skip
        collect = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        //7.map
        Set<String> set = new HashSet<>();
        set.add("");
        set.add("21");
        set.add("11");
        set.add("14");
        String c2 = set.stream().filter(s -> !"21".equals(s)).map(c -> "123").collect(Collectors.joining(","));
        System.out.println(JSON.toJSONString(c2));

        List<String> slList = set.stream().filter(String::isEmpty).map(string -> "0.01").collect(Collectors.toList());
        System.out.println(JSON.toJSONString(slList));
        //8.flatMap(T -> Stream) 每个元素再转换成流处理
//        list.stream().map(s-> Arrays.stream(s.split("1")).flatMap(s0 -> )).collect(Collectors.toList());
        //.
    }


    /**
     * @param map
     * @return
     */
    public Map<String, String> getMap(HashMap<String, String> map) {
        return map;
    }
}

@Setter
@Getter
@AllArgsConstructor
class User {

    private int age;
    private String name;
}
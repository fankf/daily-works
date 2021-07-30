package com.fankf.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fankf
 * @date 2021/7/29 13:51
 * @description
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // -------------------------------------------
        // size
        int size = list.size();
        System.out.println(size); //0
        // isEmpty
        boolean empty = list.isEmpty();
        System.out.println(empty); // true

        // contains
        boolean contains = list.contains("abc");
        System.out.println(contains); // false

        // containsAll
        boolean containsAll = list.containsAll(Arrays.asList("abc"));
        System.out.println(containsAll); // false

        // ---------------------------------------
        // 单元素操作
        list.add("abc");
        // get
        String get = list.get(0);
        System.out.println(get); //abc
        //set 替换

        String set = list.set(0, "zzzz");
        System.out.println(set); //abc

        //remove
        String remove1 = list.remove(0);
        System.out.println(remove1 + " => list:" + String.join(",", list)); // zzzz => list:

        // add
        boolean add = list.add("abc");
        System.out.println(add + ":" + list.stream().collect(Collectors.joining(","))); //true:abc

        // add 带下标添加，如果此坐标已经存在数据，则右侧所有数据右移
        list.add(0, "abcd");
        System.out.println(String.join(",", list));//abcd,abc

        // indexOf lastIndexOf
        int indexOf = list.indexOf("c");
        int lastIndexOf = list.lastIndexOf("c");
        System.out.println("indexOf:" + indexOf + " => lastIndexOf:" + lastIndexOf); // indexOf:-1 => lastIndexOf:-1

        list.clear();
        System.out.println("list:"+String.join(",", list)); // list:

        // --------------------------------------------
        // 多元素操作
        // addAll
        boolean addAll = list.addAll(Arrays.asList("c", "d"));
        System.out.println(addAll + ":" + String.join(",", list)); //true:c,d

        // 保留参数中集合也存在的元素 {"a","b","c"} retainAll {"a"} 只有 a 元素保留
        boolean retainAll = list.retainAll(Arrays.asList("a"));
        System.out.println(retainAll + " => list:" + String.join(",", list)); // true => list:

        // -----------------------------------------

        list.addAll(Arrays.asList("1","2","3"));

        // 转换数组
        Object[] objects = list.toArray();
        for (Object object : objects) {
            System.out.println("object:"+object);
            //object:1
            //object:2
            //object:3
        }
        String[] strings = list.toArray(new String[0]);
        System.out.println("==>" + String.join(",", strings)); //==>1,2,3
    }
}

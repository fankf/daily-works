package com.fankf.thread;

import java.util.Arrays;
import java.util.List;

/**
 * fankunfeng
 * 2020-12-07 09:44
 */
public class VTest {
    public static void main(String[] args) {
        VolitileTest volitileTest = new VolitileTest();
        String t = "";
        String zzstsgl = "";

        switch (t){
            case "0" : zzstsgl = "出口零税";break;
            case "1" : zzstsgl = "免税";break;
            case "2" : zzstsgl = "不征税";break;
            case "3" : zzstsgl = "普通零税率";break;
            default: zzstsgl = "";
        }
        System.out.println(zzstsgl);

        List<String> integers = Arrays.asList("1", "2", "3", "4", "5", "6");
        String join = String.join("/", integers);
        System.out.println(join);
    }
}

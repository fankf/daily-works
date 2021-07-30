package com.fankf.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fankf
 * @date 2021/7/28 10:40
 * @description
 */
public class StringTest {
    public static void main(String[] args) {

        // new
        String s1 = "123";
        System.out.println(s1); //123

        String s2 = new String();
        System.out.println(s2.getClass()); // class java.lang.String

        // 等同于 s1
        String s3 = new String("123");
        System.out.println(s3); //123

        // char[] 截取 下标0开始
        String s4 = new String(s1.toCharArray(), 1, 2);
        System.out.println(s4); //23
        // int[] 截取 对应ascii表下表
        int[] c1 = new int[]{61, 62, 63, 66, 75, 79};
        String s5 = new String(c1, 0, 5);
        System.out.println(s5); // =>?BK
        // byte[] 截取 偏移量 长度 和编码
        String s6 = new String(s1.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        System.out.println(s6); // 123


        // ---------------------------------

        //equals 比较是否相等
        boolean equals = s1.equals(s3);
        System.out.println(equals); // true
        // contentEquals 可以和 CharSequence 的实现类比较值是否相等，不考虑引用和类型
        StringBuffer stringBuffer = new StringBuffer("123");
        boolean equals1 = s1.contentEquals(stringBuffer);
        boolean equals2 = s1.equals(stringBuffer);
        System.out.println(equals1); //true
        System.out.println(equals2); // false
        //equalsIgnoreCase 忽略大小写比较是否相等
        boolean abc = "abc".equalsIgnoreCase("ABC");
        System.out.println(abc);  //true

        // regionMatches 两个字符串中的某个区域中的子串是否相等
        // 例如 str1 : abcde 和 str2: bcde 中 str1 下标从1开始4个字符和 str2  下表从0开始4个字符相等
        String str1 = "abcde";
        String str2 = "bcde";
        boolean b = str1.regionMatches(1, str2, 0, 4);
        System.out.println(b);  //true

        // ---------------------------------

        // compare 比较大小
        int compare = "abc".compareTo("bc");
        System.out.println(compare); //-1 小于

        // compareIngoreCase
        int compareIngoreCase = "abc".compareToIgnoreCase("ABC");
        System.out.println(compareIngoreCase); //0 相等


        // ---------------------------------
        // startWith 以某个字符串开始

        String str3 = "abcdeABCDE";
        boolean startsWith = str3.startsWith("abc");
        System.out.println(startsWith); //true

        // endWith 以某个字符串结束
        boolean endsWith = str3.endsWith("CDE");
        System.out.println(endsWith); //true

        //indexOf   返回该字符串中指定子字符串的第一个出现项的索引,不存在则返回-1
        int indexOf = str3.indexOf("bc");
        System.out.println(indexOf); // 1

        // lastIndexOf 返回最后一个
        int lastIndexOf = str3.lastIndexOf("bc");
        System.out.println(lastIndexOf); // 1
        // indexOf 和 lastIndexOf 存在静态方法，也可以对字符串截取查询

        // -------------------------------

        // subString subSequence 返回类型不同，功能是相同的
        String sub = "abcdeABCDE";
        String substring = sub.substring(1, 3);
        System.out.println(substring); //bc
        CharSequence charSequence = sub.subSequence(1, 3);
        System.out.println(charSequence); // bc

        // concat 增加
        String me = "to".concat("me");
        System.out.println(me); // tome

        // contains 是否包含
        boolean contains = "abcde".contains("abc");
        System.out.println(contains); //true

        // replace 替换
        String replace = "abcde".replace("ab", "cd");
        System.out.println(replace); // cdcde

        // trim 去除空格

        String trim = " adc ".trim();
        System.out.println(trim); // adc

        // split

        String[] split = "asdas,asdsa".split(",");
        for (String sp : split) {
            System.out.println(sp);  // asdas  asdsa
        }

        // join 可以进行迭代的，或者多个参数

        String join = String.join(",", "a", "c", "d");
        System.out.println(join); // a,c,d
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("z");
        list.add("sdsa");
        String join2 = String.join(",", list);
        System.out.println(join2); // 1,2,z,sdsa
        // ----------------------------------------

        // matchs 正则匹配 . 代表任意字符， * 代表任意个数
        boolean matches = "abcde".matches(".*");
        System.out.println(matches); // true

        // replaceFirst replaceAll 正则替换

        String re = "abcdeABCDE".replaceFirst(".{2}", "-");
        System.out.println(re); // -cdeABCDE
        String replaceAll = "abcdeABCDE".replaceAll(".{2}", "+");
        System.out.println(replaceAll); // +++++ 每2个字母替换成1个+，共5个

        // -----------------------------------

        // toUpperCase toLowerCase
        String lowerCase = "abcABCv".toLowerCase();
        System.out.println(lowerCase); // abcabcv
        String upperCase = "abcABCv".toUpperCase();
        System.out.println(upperCase);


        // format 转换符代替字符串，可以多个，例如 %s %d  %c 等等

        String format = String.format("abc%ssddd", "+++");
        System.out.println(format); // abc+++sddd

        // toString 转换成String返回的还是本身
        String toString = "abc".toString();
        System.out.println(toString); // abc

        // toCharArray 转换成字符数组
        char[] chars = "abc".toCharArray();
        System.out.println(chars); //abc

        // valueOf copyValueOf 其他类型转换成String  都是静态方法
        String valueOf = String.valueOf(1);
        System.out.println(valueOf); // 1
        String valueOf2 = String.valueOf(chars,0,1);
        System.out.println(valueOf2); // a
        String copyValueOf = String.copyValueOf(chars,0,1);
        System.out.println(copyValueOf); // a


        // --------------------------------------

        // intern 如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
        String strA = new String("abc");
        String strB = new String("abc");
        String strC = "abc";

        System.out.println(strA.intern() == strB); // false new 创建的时候放入了堆中
        System.out.println(strA.intern() == strC); // true

    }
}

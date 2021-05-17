package com.fankf.thread;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * fankunfeng
 * 2020-10-26 15:30
 */
public class HashMapTest {


    public static void main(String[] args) {
        Integer[] strs = {1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.asList(strs);
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integerList);
        System.out.println(integerList1);

        String a = "1.12323E6";
        DecimalFormat decimalFormat = new DecimalFormat("0");//""00.00"小数点后面的0的个数表示小数点的个数
         String s = decimalFormat.format(Double.valueOf(a));
        System.out.println(s);
    }
}

package com.fankf.utils;

import cn.hutool.core.date.DateUtil;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ObjectsTest {
    public static void main(String[] args) {
        System.out.println(DateUtil.format(LocalDateTime.now().plusMonths(1), "yyyyMM"));

        String yearMonth = "2021201";
        try {
            YearMonth yyyyMM = YearMonth.parse(yearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
        } catch (Exception e) {
            System.out.println("输入格式错误，不允许创建！");
        }
    }
}

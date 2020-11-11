package com.fankf.java8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java8TimeTest {
    public static void main(String[] args) {
        // yyyy-MM-dd HH:mm:ss 格式
        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(dataTimeFormatter);
        System.out.println(format);
        System.out.println(now);
        // 周一到周日
        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println(dayOfWeek);

        Date date = new Date();

        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(date.getTime(), 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime);
    }
}

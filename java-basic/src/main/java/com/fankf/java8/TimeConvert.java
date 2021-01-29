package com.fankf.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * fankunfeng
 * 2020-11-04 11:01
 */
public class TimeConvert {
    public static void main(String[] args) throws ParseException {
        // 1. Date = Instant 互相转换
        Date now = new Date();  //Wed Nov 11 11:02:56 CST 2020
        Instant toInstant = now.toInstant(); // 2020-11-11T03:02:56.494Z
        now = Date.from(toInstant);

        // 2. Instant 与 LocalDateTime 转换,存在时区偏移
        Instant now2 = Instant.now(); // 2020-11-11T03:02:56.498Z
        LocalDateTime localDateTime = now2.atZone(ZoneId.systemDefault()).toLocalDateTime();//2020-11-11T11:02:56.498
        now2 = localDateTime.toInstant(ZoneOffset.ofHours(8));

        // 3. LocalDateTime,LocalDate,LocalTime
        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDate localDate = localDateTime2.toLocalDate(); // 2020-11-11
        LocalTime localTime = localDateTime2.toLocalTime(); // 11:02:56.815
        localDateTime2 = LocalDateTime.of(localDate, localTime); // 2020-11-11T11:02:56.815

        // 4.毫秒数 与 Date 互转
        Date var1 = new Date(); // Wed Nov 11 11:02:56 CST 2020
        long var1Time = var1.getTime(); // 1605063776815
        var1 = new Date(var1Time);


        // 5. 毫秒数 转 Instant
        Instant instant1 = Instant.ofEpochMilli(var1Time); // 2020-11-11T03:02:56.815Z
        long var2Milli = instant1.toEpochMilli(); // 1605063776815

        // 6. 毫秒数转 LocalDateTime,这里会丢失毫秒数和之前存在误差
        LocalDateTime localDateTime1 = LocalDateTime
                .ofEpochSecond(var1Time/1000, (int) (var1Time%1000*1000),ZoneOffset.ofHours(8));// 2020-11-11T11:02:56.000815
        // 秒
        long toEpochSecond = localDateTime1.toEpochSecond(ZoneOffset.ofHours(8)); // 1605063776
        // 毫秒
        long toEpochSecond2 = localDateTime1.toInstant(ZoneOffset.ofHours(8)).toEpochMilli(); //1605063776000
        System.out.println();

        // 7. 字符串 转换 Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        Date date = simpleDateFormat.parse(format);

        // 8. 字符串 转 LocalDateTime,LocalDate,LocalTime
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse("2020-11-11 00:00:00",localDateTimeFormatter); //2020-11-11T00:00
        String formatLocalDateTime = localDateTime3.format(localDateTimeFormatter);// 2020-11-11 00:00:00

        DateTimeFormatter localDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse("2020-11-11",localDateFormat);// 2020-11-11
        String localDateString = date1.format(localDateFormat);// 2020-11-11

        DateTimeFormatter localTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse("00:00:00",localTimeFormat); //00:00
        String localTimeString = time.format(localTimeFormat);//00:00:00

        // 9. 两日期之间的间隔数，两个时间的间隔数,时间的比较
        LocalDate localDateNow = LocalDate.now(); // 2020-11-11
        LocalDate localDatePlus = localDateNow.plus(10, ChronoUnit.DAYS);// 2020-11-21
        long between = ChronoUnit.DAYS.between(localDatePlus,localDateNow);//-10
        boolean before = localDatePlus.isBefore(localDateNow);//false

        LocalTime localTimeNow = LocalTime.now();//17:12:34.717
        LocalTime LocalTimePlus = localTimeNow.plus(100, ChronoUnit.MINUTES);// 18:52:34.717
        long between2 = ChronoUnit.MINUTES.between(LocalTimePlus,localTimeNow);//-100
        boolean after = LocalTimePlus.isAfter(localTimeNow);//true

        // 10.其他
        // LocalDate 获取起始 LocalDateTime
        LocalDate localDate1 = LocalDate.now();//2020-11-11
        LocalDateTime localDateTime4 = localDate1.atStartOfDay();//2020-11-11T00:00
        // 今天星期几
        DayOfWeek dayOfWeek = localDate1.getDayOfWeek();//WEDNESDAY
        // 今天是一个月的第几天
        int dayOfMonth = localDate1.getDayOfMonth();//11
        // 今天是一年中的第几天
        int dayOfYear = localDate1.getDayOfYear();//316
        // 是否是闰年 2月28天
        boolean leapYear = localDate1.isLeapYear();//true
        // 10天后的日期
        LocalDate plus = localDate1.plus(10, ChronoUnit.DAYS);//2020-11-21


    }
}

package com.fankf.base;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * **************************************
 *
 * @AUTHOR fankunfeng
 * @DATETIME 2020-07-21 14:19
 * @PACKAGE com.fankf.base
 * <p>
 * ***************************************
 */
public class CalculateTest {
    public static void main(String[] args) throws IOException {
        if ("12".compareTo("2") > -1) {
            System.out.println("---233333-");
        }
        if (Integer.valueOf(12).compareTo(2) > -1) {
            System.out.println("---12222222-");
        }

        System.out.println("------------");
        LocalDate localDate = LocalDate.now().minusMonths(1);
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));
        java.util.Date from = Date.from(instant);

        int i = 0;
        int cal = cal(i);
        System.out.println(i + "==========" + cal);
        System.in.read();
    }


    private static int cal(int i) {
        i++;
        return i;
    }
}

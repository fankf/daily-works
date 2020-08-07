package com.fankf.base;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * **************************************
 *
 * @AUTHOR fankunfeng
 * @DATETIME 2020-07-21 14:19
 * @PACKAGE com.fankf.base
 *
 * ***************************************
 */
public class CalculateTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("------------");



    final AtomicDouble[] diff = {new AtomicDouble(0.00)};

    double remain = diff[0].addAndGet(0.01 * -1);
        System.out.println(remain);


        double v = new BigDecimal(0.00).divide(new BigDecimal(0.01), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(v);
        System.out.println(v==0.00);
        System.out.println(v==0);
        System.out.println(v<0);


        byte[] bytes = Base64Utils.decodeFromUrlSafeString("eyJERFFRUENIIjoiUFMyMDIwMDgwNjA5MTU0NzQzMzAiLCJTVEFUVVNfQ09ERSI6IjAxMDAwMCIsIlNUQVRVU19NRVNTQUdFIjoi5Y-R56Wo6K-35rGC5o6l5pS25oiQ5YqfIn0");
        String s = new String(bytes, "UTF-8");
        System.out.println(s);
    }
}

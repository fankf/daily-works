package com.fankf.base;

import com.google.common.util.concurrent.AtomicDouble;

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
    public static void main(String[] args) {
        System.out.println("------------");



    final AtomicDouble[] diff = {new AtomicDouble(0.00)};

    double remain = diff[0].addAndGet(0.01 * -1);
        System.out.println(remain);


        double v = new BigDecimal(0.00).divide(new BigDecimal(0.01), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(v);
        System.out.println(v==0.00);
        System.out.println(v==0);
        System.out.println(v<0);

    }
}

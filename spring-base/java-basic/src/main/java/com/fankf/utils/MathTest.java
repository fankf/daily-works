package com.fankf.utils;

public class MathTest {
    public static void main(String[] args) {

        //绝对值
        int abs = Math.abs(-1);
        System.out.println(abs);

        //min <-> max
        int min = Math.min(-1, 2);
        int max = Math.max(-1, 2);
        System.out.println("min -> " + min + " max -> " + max);
        //随机数 (0 , 1)
        double random = Math.random();
        System.out.println(random);

        // 四舍五入
        long round = Math.round(1.1);


        //floor 向下取 ceil 向上取
        double floor = Math.floor(-1.11);
        double ceil = Math.ceil(-1.11);
        System.out.println("floor -> " + floor + " ceil -> " + ceil);

        // 开方 乘方 （不精确）
        double sqrt = Math.sqrt(0.16);
        double pow = Math.pow(0.2, 3);
        System.out.println("sqrt -> " + sqrt + " pow -> " + pow);

        // 精准 加减乘除
        int i0 = Math.addExact(1, 1);
        int i1 = Math.subtractExact(1, 1);
        int i2 = Math.multiplyExact(1, 1);

        System.out.println(i0 + " " + i1 + " " + i2);

        // 精准 递增 递减
        int k0 = Math.incrementExact(2);
        int k1 = Math.decrementExact(2);
        System.out.println(k0 + " " + k1);

        // 三角函数 反三角函数 （不精确）
        double sin = Math.sin(0.8);
        double cos = Math.cos(0.6);
        double tan = Math.tan(0.75);
        System.out.println(sin + " - " + cos + " - " + tan);
        double acos = Math.cos(0.6);
        double atan = Math.atan(0.6);
        double asin = Math.sin(0.6);
        System.out.println(asin + " - " + acos + " - " + atan);

        // 自然数e 圆周率Π (不精确)
        double e = Math.E;
        double pi = Math.PI;
        System.out.println("e -> " + e + "pi -> " + pi);

        float signum = Math.signum(123);
        System.out.println("signum - " + signum);

        double scalb = Math.scalb(123.123, 2);
        System.out.println("scalb - " + scalb);
    }
}

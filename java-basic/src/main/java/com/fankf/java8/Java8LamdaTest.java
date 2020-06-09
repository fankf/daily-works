package com.fankf.java8;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.newThread;

/**
 * lambda 表达式
 * <p>
 * 1.主要用来定义行内执行的方法类型接口
 * 2. 免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力
 * </p>
 *
 * @author fan
 * @create 2020-06-08 22:25
 * @description
 * @see
 */
public class Java8LamdaTest {
    public static void main(String[] args) {
//        simple();
        //interface default return 写法
        intefaceReturn();
        newThread();
    }

    /**
     * 代替 new Runnable() 接口
     */
    private static void newThread() {
        Thread d = new Thread(() -> System.out.println("1"));
        d.start();
    }

    private static void intefaceReturn() {
//        Interface00 i00 = (a, b) -> 1;
    }

    interface Interface00 {
        default int method00(int a, int b) {
            return a + b;
        }
    }

    /*
       1. 简单示例
       1.1 无需参数直接返回
       1.2 接收一个数字类型，对数字进行计算
       1.3 接收2个参数，进行加法运算
       1.4 接收带类型String的参数，返回拼接结果
       1.5 接收一个String,打印到控制台
    */
    private static void simple() {
        Interface0 i0 = () -> 5;
        Interface1 i1 = (a) -> a + 1;
        Interface2 i2 = (a, b) -> a + b;
        Interface3 i3 = (a) -> a + "K";
        Interface4 i4 = (a) -> System.out.println(a);
        System.out.println(i0.method0());
        System.out.println(i1.method1(12));
        System.out.println(i2.method1(12, 12));
        System.out.println(i3.method1(12));
        i4.method1(213);

    }

    interface Interface0 {
        int method0();
    }

    interface Interface1 {
        int method1(int a);
    }

    interface Interface2 {
        int method1(int a, int b);
    }

    interface Interface3 {
        String method1(int a);
    }

    interface Interface4 {
        void method1(int a);
    }
}

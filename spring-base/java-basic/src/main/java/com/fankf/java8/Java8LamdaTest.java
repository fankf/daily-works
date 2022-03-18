package com.fankf.java8;

import com.alibaba.fastjson.JSON;
import com.fankf.bean.People;
import com.fankf.bean.Student0;
import org.junit.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Collator;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;


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
    //  方法引用和数组引用
    @Test
    public void lambda0(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        YearMonth parse = YearMonth.parse("2011-01-01",dateTimeFormatter );
        System.out.println(parse);
        //一个参数
        Supplier<Student0> su0 = Student0::new;
        System.out.println(su0.get());
        //2 个参数
        Function<Integer,Student0> su1 = Student0::new;
        System.out.println(su1.apply(12));
        //3 个参数
        BiFunction<Integer,String,Student0> su2 = Student0::new;
        System.out.println(su2.apply(12,"ZZZZ"));

        //数组引用
        Function<Integer,int[]> function = int[]::new;
        int[] apply = function.apply(22);
        System.out.println(apply);
    }

    //核心lambda
    @Test
    public void testLambdaCore() {
        // 无返回 一个参数
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(123);

        // 一个返回 一个参数 函数式
        Function<String, Integer> fun = Integer::valueOf;
        System.out.println(fun.apply("123"));

        //无参数 有返回
        Supplier<People> supplier = People::new;
        System.out.println(supplier.get());

        //一个参数 返回 boolean
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
    }

    /**
     * 代替 new Runnable() 接口
     */
    @Test
    public void newThread() {
        // runnable
        Thread d0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        // runnable lambda
        Thread d = new Thread(() -> System.out.println("1"));
        d.start();
    }

    /*
     *  comparator
     */
    @Test
    public void newCompare() {
        // comparetor
        String[] strs = new String[]{"asdas", "dasfa"};
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // ::
        Arrays.sort(strs, String::compareTo);
        // comparator lambda
        Comparator<String> comparator = (String a, String b) -> (a.compareTo(b));
        Arrays.sort(strs, comparator);


        //中文排序
        Collator collator = Collator.getInstance(Locale.CHINA);
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

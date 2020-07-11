package com.fankf.java8;

import com.fankf.bean.Student0;
import com.fankf.bean.Student1;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Stream 主要作用的操作集合
 * 集合的作用是存储数据，作用域 内存
 * stream 作用是计算 作用于 CPU
 *
 * <p>
 * <p>
 * > Stream 的创建
 * 四种创建方法
 * 1. 集合 List/Set 等
 * 2. 数组 int[] 等
 * 3. Stream.of
 * 4. Stream.iterator 迭代无限流 Stream.generator 生成无限流
 * > Stream 的中间操作
 * 1. 过滤/分片 filter  limit  skip district
 * 2. 映射 map flatMap
 * 3. 排序 sort sort(Comparator com)
 * > Stream 的终止操作
 * 1. 查询
 * 2. 规约
 * </p>
 */
public class StreamTest {

    // collect
    @Test
    public void test() {
        //toList
        List<Student1> list = Student1.list();
        List<Student1> collect = list.stream().filter(a -> a.getId() > 102).collect(toList());
        collect.forEach(System.out::println);
        System.out.println();
        //toSet
        Set<Student1> set = list.stream().filter(a -> a.getId() > 102).collect(toSet());
        set.forEach(System.out::println);
        System.out.println();
        //toCollection 选择集合
        Set<Student1> set0 = list.stream().filter(a -> a.getId() > 102).collect(Collectors.toCollection(HashSet::new));
        set0.forEach(System.out::println);
        System.out.println();
        List<Student1> list1 = list.stream().filter(a -> a.getId() > 102).collect(Collectors.toCollection(LinkedList::new));
        list1.forEach(System.out::println);
        System.out.println();

        // map 转换成map
        Map<Integer, Student1> collect1 = list.stream().filter(a -> a.getId() > 102).collect(Collectors.toMap(Student1::getId, Function.identity()));
        collect1.keySet().forEach(System.out::println);
        System.out.println();
        collect1.values().forEach(System.out::println);
        System.out.println();

        //join 拼接集合 只能拼接字符串  单个参数直接拼接 ，一个参数中间夹杂，三个参数后两个拼接在首尾
        List<Integer> numbers = Arrays.asList(1, 23, 53, 5, 24643, 1, 234);
        String nums = numbers.stream().map(String::valueOf).collect(joining());
        System.out.println(nums);
        System.out.println();
        String nums2 = numbers.stream().map(String::valueOf).collect(joining(","));
        System.out.println(nums2);
        System.out.println();
        String nums3 = numbers.stream().map(String::valueOf).collect(joining(",", "==>", "<=="));
        System.out.println(nums3);

        // counting 统计个数
        long l = numbers.stream().map(a -> a + 1).collect(counting());
        System.out.println(l);
        System.out.println();

        // summingInt 求和
        Integer integer = list.stream().collect(summingInt(Student1::getId));
        System.out.println(integer);
        System.out.println();
        //maxBy/minBy
        Optional<Student1> max = list.stream().collect(maxBy(Comparator.comparingLong(o -> o.getId())));
        Optional<Student1> min = list.stream().collect(minBy(Comparator.comparingLong(o -> o.getId())));
        System.out.println(max + "---" + min);
        System.out.println();


        // summarizingInt 收集统计数据
        IntSummaryStatistics summaryStatistics = list.stream().collect(summarizingInt(Student1::getId));
        System.out.println(summaryStatistics.getMax() + " = " + summaryStatistics.getAverage());
        System.out.println("================");
        // groupBy
        Map<Boolean, List<Student1>> collect2 = list.stream().collect(groupingBy(o -> o.getId() > 103));
        collect2.values().forEach(o -> System.out.println(o));
        System.out.println();

        // partitioningBy == groupBy Boolean 做key 是group 的一种特殊情况
        Map<Boolean, List<Student1>> collect3 = list.stream().collect(partitioningBy(o -> o.getId() > 103));
        collect3.values().forEach(o -> System.out.println(o));
        System.out.println();
        //reducing 规约
        Integer collect4 = list.stream().collect(reducing(0, Student1::getId, Integer::sum));
        System.out.println(collect4);
    }

    //reduce
    @Test
    public void end1() {
        // reduce(T,BinaryOperator) T 和返回值相同并且 为初始值
        List<Integer> integers = Arrays.asList(1, 23, 5, 123, 51, 535);
        Integer reduce = integers.stream().reduce(10, Integer::sum);
        System.out.println(reduce);
        // reduce(BinaryOperator)
        List<Student1> list = Student1.list();
        Optional<Integer> reduce1 = list.stream().map(Student1::getId).reduce(Integer::sum);
        System.out.println(reduce1);

    }

    // 查找
    @Test
    public void end0() {
        List<Student1> list = Student1.list();
        // allMatch 所有匹配
        boolean allMatch = list.stream().allMatch(a -> a.getId() > 1);
        System.out.println(allMatch);
        // anyMatch 只要有一个匹配
        boolean anyMatch = list.stream().anyMatch(a -> a.getId() > 1);
        System.out.println(anyMatch);
        // noneMatch 只要有一个不匹配
        boolean noneMatch = list.stream().noneMatch(a -> a.getId() > 1);
        System.out.println(noneMatch);
        System.out.println();
        // findFirst 找到第一个
        Optional<Student1> first = list.stream().findFirst();
        System.out.println(first);
        // findAny 随机找到一个
        Optional<Student1> any = list.stream().findAny();
        System.out.println(any);
        System.out.println();
        // count 统计个数
        long count = list.stream().count();
        System.out.println(count);
        System.out.println();
        // max 最大的
        Optional<Student1> max = list.stream().max(Comparator.comparingInt(Student1::getId));
        System.out.println(max);
        System.out.println();
        // min 最小的
        Optional<Student1> min = list.stream().min(Comparator.comparingInt(Student1::getId));
        System.out.println(min);
        System.out.println();
        // forEach 外部迭代
        list.forEach(System.out::println);
        System.out.println();
        // stream的叫内部迭代
        list.stream().forEach(System.out::println);
    }

    //sort
    @Test
    public void mid2() {
        Stream<Integer> sort0 = Stream.of(1, 23, 4, 1, 123, 4);
        sort0.sorted().forEach(System.out::println);
        System.out.println();
        List<Student1> list = Student1.list();
        list.stream().sorted((Comparator.comparing(Student1::getName))).forEach(System.out::println);

    }

    // map flatMap
    @Test
    public void mid1() {
        List<Student0> list = Student0.list();
        // map 获取所有 student 的name
        Stream<String> stringStream = list.stream().map(Student0::getName);
        stringStream.forEach(System.out::println);
        System.out.println();


        Stream<String> stream = list.stream().map(Student0::getName).limit(2);

        Stream<Stream<Character>> streamStream = stream.map(s -> chars(s));
        streamStream.forEach(a -> a.forEach(
                System.out::println
        ));
        System.out.println();
        //flatMap
        Stream<String> stream1 = list.stream().map(Student0::getName).limit(2);
        Stream<Character> characterStream = stream1.flatMap(this::chars);
        characterStream.forEach(System.out::println);
    }

    private Stream<Character> chars(String s) {
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void mid0() {
        List<Student0> list = Student0.list();
        //filter 过滤 name = AAA
        Stream<Student0> stream0 = list.stream().filter(s -> "AAA".equals(s.getName()));
        stream0.forEach(Student0::toString);

        System.out.println();
        // limit
        Stream<Integer> limit = Stream.iterate(0, 啊 -> 啊 + 1).limit(4);
        limit.forEach(System.out::println);
        System.out.println();
        // skip
        Stream<Integer> limit0 = Stream.iterate(0, 啊 -> 啊 + 1).skip(10).limit(6);
        limit0.forEach(System.out::println);
        System.out.println();
        // district
        Stream<Integer> limit1 = Stream.iterate(0, a -> a).skip(10).limit(2).distinct();
        limit1.forEach(System.out::println);
    }


    @Test
    public void create() {
        // 1. 集合
        List<String> strings = Arrays.asList("1", "ZZ", "dd");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);

        System.out.println();

        //数组
        int[] tt = {1, 3, 5, 22, 3, 5};
        IntStream intStream = Arrays.stream(tt);
        intStream.forEach(System.out::println);
        System.out.println();

        // Stream
        Stream<Integer> integerStream = Stream.of(123, 41, 1232);
        integerStream.forEach(System.out::println);
        System.out.println();

        //无限流
        Stream<Integer> iterate = Stream.iterate(0, a -> a + 1);
        iterate.limit(10).forEach(System.out::println);
        System.out.println();
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);
        System.out.println();
    }

}

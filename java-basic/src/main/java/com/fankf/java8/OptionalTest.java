package com.fankf.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional 操作
 * 》 创建 Optional 的方式
 * 1. Optional.of(T t) 获取Optional的对象，对象不能为空
 * 2. Optional.empty() 获取空对象的Optional
 * 3. Optional.ofNullable(T t) 获取Optional的对象，对象可以为空
 * 》 判断是否包含对象
 * 1.boolean isPresent() 判断是否存在
 * 2.void ifPresent(Consumer<? super T> consumer) 如果有值，返回Consumer<T> T为存在的类型
 * 》 获取 Optional 容器中的对象
 * 1. T get() 如果有值返回，没有抛异常
 * 2. T ofElse(T t ) 如果有值返回，没有返回他新对象
 * 3. T ofElseGet(Supplier<? super T> supplier) 如果有值返回，没有返回Supplier返回的新对象
 * 4. T ofElseThrow(Supplier<? super X> supplier) 如果有值返回，没有返回Supplier返提供的异常
 */
public class OptionalTest {

    @Test
    public void test1(){
        Boy boy = new Boy();
        Optional<Boy> boy1 = Optional.of(boy);
        System.out.println(boy1);
        //get
        Boy boy2 = boy1.get();
        System.out.println(boy2);
        Girl girl = boy2.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);

        System.out.println("--"+girl1.orElse(new Girl("小花")));
    }
    
    // 创建
    @Test
    public void test(){
        Boy boy = new Boy();
        boy = null;
        Optional<Boy> boy1 = Optional.empty();
//        Optional<Boy> boy1 = Optional.of(boy);
//        Optional<Boy> boy1 = Optional.ofNullable(boy);
        System.out.println(boy1);
    }
}


class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}

class Girl {
    private String name;
    public Girl(){}
    public Girl(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
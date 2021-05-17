package com.fankf.sign.adapter;

/**
 * **************************************
 *
 *
 * 适配器类模式
 *  Person 有两个方法 ,
 *  但是Beijing 只实现了一个 area,另外一个由Chinese实现
 *
 * @author fankunfeng
 * @datetime 2020-07-21 18:00
 * @package com.fankf.sign.adapter
 * ***************************************
 * @see Person#country()
 * @see Person#area()
 *
 */
public class Beijing extends Chinese implements Person {
    @Override
    public void area() {
        System.out.println("我来自北京地区`~");
    }
}

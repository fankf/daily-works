package com.fankf.sign.template;

/**
 * @author fankunfeng
 * @datetime 2020-07-24 10:42
 * @package com.fankf.sign.template
 */
public class Teacher extends Person{
    @Override
    void doSomething() {
        System.out.println("我在教学...");
    }

    @Override
    void state() {
        System.out.println("我在进行网络教学...");
    }
}

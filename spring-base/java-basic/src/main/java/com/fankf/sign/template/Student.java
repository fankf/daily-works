package com.fankf.sign.template;

/**
 * @author fankunfeng
 * @datetime 2020-07-24 10:41
 * @package com.fankf.sign.template
 */
public class Student extends Person{
    @Override
    void doSomething() {
        System.out.println("我正在读书...");
    }

    @Override
    void state() {
        System.out.println("我在教室里...");
    }
}

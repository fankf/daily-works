package com.fankf.sign.template;

/**
 *  父类与子类的关系
 * 抽象类实现模板方法，Person 的state 方法就是
 *
 * @author fankunfeng
 * @datetime 2020-07-24 10:43
 * @package com.fankf.sign.template
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.state();
        p.doSomething();

        Person p2 = new Teacher();
        p2.state();
        p2.doSomething();
    }
}

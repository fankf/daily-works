package com.fankf.sign.adapter;

/**
 * **************************************
 *
 *  适配器模式 对象方式
 *
 * @author fankunfeng
 * @datetime 2020-07-21 18:06
 * @package com.fankf.sign.adapter
 * ***************************************
 */
public class Henan implements Person{

    private Chinese chinese;

    public Henan(Chinese chinese) {
        this.chinese = chinese;
    }

    @Override
    public void country() {
        chinese.country();
    }

    @Override
    public void area() {
        System.out.println("我来自河南~~");
    }
}

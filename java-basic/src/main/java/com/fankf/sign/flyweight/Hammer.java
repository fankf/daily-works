package com.fankf.sign.flyweight;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:58
 * @package com.fankf.sign.flyweight
 */
public class Hammer {

    public Hammer() {
        System.out.println(" 创建一个锤子 ....");
    }

    public void use() {

        System.out.println(" 使用锤子 .... 剩余 锤子个数 ：" + Tools.list.size());
    }
}

package com.fankf.sign.adapter;

/**
 * **************************************
 *
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。
 *
 * @author fankunfeng
 * @datetime 2020-07-21 18:12
 * @package com.fankf.sign.adapter
 * ***************************************
 */
public class AdapterTest {


    public static void main(String[] args) {
        Person p1 = new Beijing();
        p1.country();
        p1.area();

        Person p2 = new Henan(new Chinese());
        p2.country();
        p2.area();

        Person p3 = new LiaoNing();
        p3.country();
        p3.area();

        Person p4 = new GuangDong();
        p4.country();
        p4.area();
    }

}

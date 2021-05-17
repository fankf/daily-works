package com.fankf.sign.proxy;

/**
 * **************************************
 *
 * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作
 *
 * @author fankunfeng
 * @datetime 2020-07-22 19:29
 * @package com.fankf.sign.proxy
 * ***************************************
 */
public class Proxy implements Sourcable{

    private Sourcable sourcable;

    public Proxy(){
        super();
        this.sourcable = new Source2();
    }

    @Override
    public void method1() {
        System.out.println("before proxy method explain....");
        sourcable.method1();
        System.out.println("after proxy method explain....");
    }
}

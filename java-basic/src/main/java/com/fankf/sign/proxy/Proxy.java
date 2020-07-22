package com.fankf.sign.proxy;

/**
 * **************************************
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

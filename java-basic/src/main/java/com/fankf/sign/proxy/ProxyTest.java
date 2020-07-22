package com.fankf.sign.proxy;

/**
 * **************************************
 *
 * @author fankunfeng
 * @datetime 2020-07-22 19:33
 * @package com.fankf.sign.proxy
 * ***************************************
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourcable sourcable = new Proxy();
        sourcable.method1();
    }
}

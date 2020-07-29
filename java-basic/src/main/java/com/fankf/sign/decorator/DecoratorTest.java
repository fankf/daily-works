package com.fankf.sign.decorator;

/**
 * **************************************
 *
 *  顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，
 *  要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 *
 * @author fankunfeng
 * @datetime 2020-07-22 14:20
 * @package com.fankf.sign.decorator
 * ***************************************
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Sourcable sourcable = new DecoratorSource(new Source());
        sourcable.method();
    }
}

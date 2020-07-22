package com.fankf.sign.decorator;

/**
 * **************************************
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

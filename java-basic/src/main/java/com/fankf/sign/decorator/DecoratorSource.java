package com.fankf.sign.decorator;

/**
 * **************************************
 *
 * @author fankunfeng
 * @datetime 2020-07-22 11:49
 * @package com.fankf.sign.decorator
 * ***************************************
 */
public class DecoratorSource implements Sourcable {

    private Sourcable source;

    public DecoratorSource(Sourcable source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before method ...");
        source.method();
        System.out.println("after method ...");
    }
}

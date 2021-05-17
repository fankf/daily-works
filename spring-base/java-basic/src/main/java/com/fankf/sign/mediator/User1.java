package com.fankf.sign.mediator;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 10:04
 * @package com.fankf.sign.madiator
 */
public class User1 extends Person {
    public User1(Media mediator) {
        super(mediator);
    }

    @Override
    public void exe() {
        System.out.println(" user1 exe ...");
    }
}

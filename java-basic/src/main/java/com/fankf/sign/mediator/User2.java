package com.fankf.sign.mediator;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 10:04
 * @package com.fankf.sign.madiator
 */
public class User2 extends Person {
    public User2(Media mediator) {
        super(mediator);
    }

    @Override
    public void exe() {
        System.out.println(" user2 exe ...");
    }
}

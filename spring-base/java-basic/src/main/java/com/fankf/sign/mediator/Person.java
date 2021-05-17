package com.fankf.sign.mediator;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 10:04
 * @package com.fankf.sign.madiator
 */
public abstract class Person {

    public Media getMediator() {
        return mediator;
    }

    public Person(Media mediator) {
        this.mediator = mediator;
    }

    private Media mediator;

    public abstract void exe();
}

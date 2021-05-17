package com.fankf.sign.strategy;

public class Person {

    public Person(AbstractAction action) {
        this.action = action;
    }

    private AbstractAction action;

    public AbstractAction getAction() {
        return action;
    }

    public void setAction(AbstractAction action) {
        this.action = action;
    }

    public void excute(String name) {
        action.action(name);
    }
}

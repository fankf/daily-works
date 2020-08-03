package com.fankf.sign.state;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:50
 * @package com.fankf.sign.state
 */
public class Context {

    private State state;


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context(State state) {
        this.state = state;
    }

    public void method() {
        if ("s1".equals(state.getValue())) {
            state.m1();
        } else if ("s2".equals(state.getValue())) {
            state.m2();
        }

    }
}

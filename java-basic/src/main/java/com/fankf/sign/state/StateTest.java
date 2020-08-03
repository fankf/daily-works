package com.fankf.sign.state;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:54
 * @package com.fankf.sign.state
 */
public class StateTest {
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);

        state.setValue("s1");
        context.method();

        state.setValue("s2");
        context.method();

    }
}

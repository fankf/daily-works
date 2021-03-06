package com.fankf.sign.interpreter;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 11:15
 * @package com.fankf.sign.interpreter
 */
public class InterpreterTest {

    public static void main(String[] args) {
        Context context = new Context(1, 3);
        Express express = new Plus();
        int expression = express.expression(context);
        System.out.println(expression);
        String[] st = new String[1];
        System.out.println(st);
        System.out.println(st.length);
        System.out.println(st == null);
        System.out.println(st.length == 0);
    }
}

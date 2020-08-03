package com.fankf.sign.command;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:24
 * @package com.fankf.sign.command
 */
public class CommondTest {

    public static void main(String[] args) {
        Commond commond = new DoComond(new Receiver());
        Invoker invoker = new Invoker(commond);
        invoker.invoker();
    }
}

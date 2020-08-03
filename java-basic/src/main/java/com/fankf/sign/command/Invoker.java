package com.fankf.sign.command;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:21
 * @package com.fankf.sign.command
 */
public class Invoker {

    private Commond commond;

    public Invoker(Commond commond) {
        this.commond = commond;
    }

    public void invoker(){
        commond.exe();
    }
}

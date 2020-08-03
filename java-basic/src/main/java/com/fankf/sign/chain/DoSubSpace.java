package com.fankf.sign.chain;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 11:13
 * @package com.fankf.sign.chain
 */
public class DoSubSpace extends AbstractChain {

    @Override
    public void doSomething(String str) {
        System.out.println("去除两边的空格");

        if(getChain() != null){
            getChain().doSomething(str);
        }
    }
}

package com.fankf.sign.chain;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 11:14
 * @package com.fankf.sign.chain
 */
public class DoSplitByNot extends AbstractChain {


    @Override
    public void doSomething(String str) {
        System.out.println("按照逗号分割。。。");
        if(getChain() != null){
            getChain().doSomething(str);
        }
    }
}

package com.fankf.sign.chain;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 11:15
 * @package com.fankf.sign.chain
 */
public class DoReplaceA extends AbstractChain {

    @Override
    public void doSomething(String str) {
        System.out.println("替换所有的字母A为空。。。");

        if(getChain() != null){
            getChain().doSomething(str);
        }
    }
}

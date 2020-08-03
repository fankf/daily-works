package com.fankf.sign.chain;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 11:16
 * @package com.fankf.sign.chain
 */
public class StringChainDoTest {

    public static void main(String[] args) {
        String str = "         asdwqr,gdag,qweqwgt,hsd       ";
        DoSubSpace chain1 = new DoSubSpace();
        DoReplaceA chain2 = new DoReplaceA();
        DoSplitByNot chain3 = new DoSplitByNot();

        chain1.setChain(chain2);
        chain2.setChain(chain3);

        chain1.doSomething(str);
    }
}

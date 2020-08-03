package com.fankf.sign.chain;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 13:56
 * @package com.fankf.sign.chain
 */
public abstract class AbstractChain implements Chain{

    private Chain chain;

    public Chain getChain() {
        return chain;
    }

    public void setChain(Chain chain) {
        this.chain = chain;
    }
}

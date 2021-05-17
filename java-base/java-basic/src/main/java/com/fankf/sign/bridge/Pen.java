package com.fankf.sign.bridge;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:00
 * @package com.fankf.sign.bridge
 */
public class Pen extends BridgeTool{

    @Override
    public void doSomething() {
        super.getWritable().write();
    }
}

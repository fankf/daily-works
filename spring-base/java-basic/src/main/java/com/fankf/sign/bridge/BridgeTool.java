package com.fankf.sign.bridge;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 16:58
 * @package com.fankf.sign.bridge
 */
public abstract class BridgeTool {

    private Writable writable;


    protected void doSomething(){
        writable.write();
    };

    public Writable getWritable() {
        return writable;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}

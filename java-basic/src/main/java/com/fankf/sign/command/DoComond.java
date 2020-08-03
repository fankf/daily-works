package com.fankf.sign.command;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:22
 * @package com.fankf.sign.command
 */
public class DoComond implements Commond {
    private Receiver receiver;

    public DoComond(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.receiver();
    }
}

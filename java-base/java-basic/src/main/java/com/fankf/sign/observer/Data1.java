package com.fankf.sign.observer;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 10:40
 * @package com.fankf.sign.observer
 */
public class Data1 implements DataInterface{
    @Override
    public void update() {
        System.out.println("data 1 update ...");
    }
}

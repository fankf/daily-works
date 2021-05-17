package com.fankf.sign.bridge;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:01
 * @package com.fankf.sign.bridge
 */
public class Paper implements Writable{
    @Override
    public void write() {
        System.out.println("把汉字写到纸上...");
    }
}

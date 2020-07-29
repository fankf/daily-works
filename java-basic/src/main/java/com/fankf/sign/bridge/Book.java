package com.fankf.sign.bridge;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:02
 * @package com.fankf.sign.bridge
 */
public class Book implements Writable{
    @Override
    public void write() {
        System.out.println("把汉字写到书上...");
    }
}

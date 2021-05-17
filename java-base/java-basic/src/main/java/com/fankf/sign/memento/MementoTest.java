package com.fankf.sign.memento;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:40
 * @package com.fankf.sign.memento
 */
public class MementoTest {
    public static void main(String[] args) {
        Origin origin = new Origin("zzz");

        Storage storage = new Storage(origin.createMemento());

        System.out.println(origin.getValue());
        origin.setValue("AAA");
        System.out.println(origin.getValue());
        origin.restore(storage.getMemento());
        System.out.println(origin.getValue());

    }
}

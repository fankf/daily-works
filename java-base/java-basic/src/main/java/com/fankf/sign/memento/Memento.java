package com.fankf.sign.memento;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:35
 * @package com.fankf.sign.memento
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

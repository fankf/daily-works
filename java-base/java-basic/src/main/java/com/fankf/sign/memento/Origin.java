package com.fankf.sign.memento;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:36
 * @package com.fankf.sign.memento
 */
public class Origin {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Origin(String value) {
        this.value = value;
    }

    private String value;

    public Memento createMemento() {
        return new Memento(value);
    }

    public void restore(Memento memento) {
        this.value = memento.getValue();
    }


}

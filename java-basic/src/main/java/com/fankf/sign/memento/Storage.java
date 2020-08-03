package com.fankf.sign.memento;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:37
 * @package com.fankf.sign.memento
 */
public class Storage {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Storage(Memento memento) {
        this.memento = memento;
    }
}

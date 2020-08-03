package com.fankf.sign.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 17:27
 * @package com.fankf.sign.iterator
 */
public class ECollection<T> implements Iterator<T> {

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    private List<T> list = new ArrayList<>();

    private int key;

    @Override
    public boolean hasNext() {
        if (list.size() < key + 1)
            return false;
        return true;
    }

    @Override
    public T next() {
        T t = list.get(key);
        key++;
        return t;
    }

    @Override
    public boolean remove(T o) {
        return list.remove(o);
    }
}

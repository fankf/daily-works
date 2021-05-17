package com.fankf.sign.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 10:43
 * @package com.fankf.sign.observer
 */
public abstract class Observer<T> {

    protected Map<String, List<T>> map = new HashMap<>();


    public void add(String key, T t) {
        List<T> ts = map.get(key);
        if (ts == null) {
            ts = new ArrayList<>();
        }
        ts.add(t);
        map.put(key,ts);

    }

    public void remove(String key, T t) {
        List<T> ts = map.get(key);
        if (ts == null) {
            ts = new ArrayList<>();
        }
        ts.remove(t);
        map.put(key,ts);
    }

    public abstract void update(String key);


}

package com.fankf.sign.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fankunfeng
 * @datetime 2020-07-23 17:58
 * @package com.fankf.sign.flyweight
 */
public class Tools {
    public static List<Hammer> list;

    private int min = 2;
    private int max = 10;


    public Tools() {
        list = new ArrayList<>(min);
        list.add(new Hammer());
        list.add(new Hammer());
    }

    public void back() {
        list.add(new Hammer());
    }

    public Hammer get() {
        if (list.size() > 0) {
            Hammer hammer = list.get(0);
            if (list.size() < 2) {
                list.add(new Hammer());
            }
            list.remove(hammer);
            return hammer;
        } else {
            return null;
        }

    }
}

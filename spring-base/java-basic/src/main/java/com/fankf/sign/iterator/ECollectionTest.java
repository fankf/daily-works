package com.fankf.sign.iterator;

import java.util.Arrays;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 17:43
 * @package com.fankf.sign.iterator
 */
public class ECollectionTest {
    public static void main(String[] args) {
        ECollection<Integer> e = new ECollection<>();
        e.setList(Arrays.asList(1,23,45,612,5623,2,3,5123,532));

        System.out.println(e.hasNext());
        System.out.println(e.next());
        while(e.hasNext()){
            System.out.println(e.next());
        }
    }
}

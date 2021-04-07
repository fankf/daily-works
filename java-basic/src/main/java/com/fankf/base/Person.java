package com.fankf.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author fankunfeng
 * 2021-04-06 15:52
 */
@Setter
@Getter
@ToString
public class Person implements Cloneable{
    private String id ;
    private Object explain;
    private String name ;
    private List<Child> childList;
    private int[] scores;
    private Sex sex;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

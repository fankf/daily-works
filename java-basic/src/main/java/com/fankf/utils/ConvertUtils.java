package com.fankf.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * fankunfeng
 * 2020-10-29 11:30
 */
public class ConvertUtils {
    // 数组转list
    public <T> List<T> toList(T[] ts){
        List<T> tList = new ArrayList<>(ts.length);
        Collections.addAll(tList, ts);
        return tList;
    }
}

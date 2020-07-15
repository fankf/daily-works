package com.fankf.sign.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 16:11
 * @PACKAGE -> com.fankf.sign.filter
 */
public class OneFilter implements BaseFilter{
    @Override
    public List<User> doFilter(List<User> object, BaseFilter filter) {
        System.out.println("one filter ...");
        object = object.stream().filter(o -> o.getUserId() != 1).collect(Collectors.toList());
        object = filter.doFilter(object,null);
        return object;
    }
}


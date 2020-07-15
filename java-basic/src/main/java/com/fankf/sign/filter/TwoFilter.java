package com.fankf.sign.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @AUTHOR fankunfeng
 * @DATETIME 2020-07-15 16:16
 * @PACKAGE com.fankf.sign.filter
 */
public class TwoFilter implements BaseFilter {
    @Override
    public List<User> doFilter(List<User> object, BaseFilter filter) {
        System.out.println("two filter ...");
        object = object.stream().filter(o -> o.getUserId() < 21).collect(Collectors.toList());
        return object;
    }
}

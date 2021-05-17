package com.fankf.sign.filter;

import java.util.List;

/**
 * @AUTHOR -> fankunfeng
 * @USER -> thinkpad
 * @DATETIME -> 2020-07-15 16:12
 * @PACKAGE -> com.fankf.sign.filter
 */
public interface BaseFilter {
    List<User> doFilter(List<User> object, BaseFilter filter);
}

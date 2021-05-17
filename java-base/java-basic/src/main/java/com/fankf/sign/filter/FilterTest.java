package com.fankf.sign.filter;

import java.util.List;

/**
 * @AUTHOR fankunfeng
 * @DATETIME 2020-07-15 16:53
 * @PACKAGE com.fankf.sign.filter
 */
public class FilterTest {
    public static void main(String[] args) {
        List<User> instance = User.instance();
        BaseFilter var0 = new OneFilter();
        BaseFilter var1 = new TwoFilter();
        List<User> users = var0.doFilter(instance, var1);

        users.forEach(System.out::println);
    }
}

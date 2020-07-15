package com.fankf.sign.filter;

import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR fankunfeng
 * @DATETIME 2020-07-15 16:46
 * @PACKAGE com.fankf.sign.filter
 */
public class User {

    private int userId;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }

    public static List<User> instance() {
        User user1 = new User(1, "AA");
        User user2 = new User(2231, "SS");
        User user3 = new User(11, "DDD");
        User user4 = new User(15, "TT");
        User user5 = new User(11, "ZZ");
        return Arrays.asList(user1, user2, user3, user4, user5);
    }
}

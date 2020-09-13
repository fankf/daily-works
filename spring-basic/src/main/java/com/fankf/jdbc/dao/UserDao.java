package com.fankf.jdbc.dao;

import com.fankf.jdbc.bean.User1;

import java.util.List;

/**
 * fankunfeng
 * 2020-09-12 13:35
 */
public interface UserDao {

    int addUser(User1 user);

    int updateUserById(User1 user);

    int deleteUserById(int id);

    int countUser();

    User1 selectUserById(int id);

    List<User1> selectUsers();

    int[] insertUser1s(List<Object[]> args);

    int[] updateUser1s(List<Object[]> args);

    int[] deleteUser1s(List<Object[]> args);
}

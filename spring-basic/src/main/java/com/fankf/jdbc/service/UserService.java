package com.fankf.jdbc.service;

import com.fankf.jdbc.bean.User1;
import com.fankf.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * fankunfeng
 * 2020-09-12 13:35
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int insertUser(User1 user) {
        int insert = userDao.addUser(user);
        return insert;
    }

    public int updateUserById(User1 user) {
        int insert = userDao.updateUserById(user);
        return insert;
    }

    public int deleteUserById(int id) {
        int insert = userDao.deleteUserById(id);
        return insert;
    }

    public int countUser() {
        int insert = userDao.countUser();
        return insert;
    }

    public User1 selectUserById(int id) {
        User1 user = userDao.selectUserById(id);
        return user;
    }

    public List<User1> selectUser() {
        List<User1> user1List = userDao.selectUsers();
        return user1List;
    }

    public int insertBatch(List<Object[]> args) {
        int[] count = userDao.insertUser1s(args);
        int sum = Arrays.stream(count).sum();
        return sum;
    }

    public int updateBatch(List<Object[]> args) {
        int[] count = userDao.updateUser1s(args);
        int sum = Arrays.stream(count).sum();
        return sum;
    }

    public int deleteBatch(List<Object[]> args) {
        int[] count = userDao.deleteUser1s(args);
        int sum = Arrays.stream(count).sum();
        return sum;
    }
}

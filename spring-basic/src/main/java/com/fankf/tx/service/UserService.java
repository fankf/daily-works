package com.fankf.tx.service;

import com.fankf.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * fankunfeng
 * 2020-09-12 23:53
 */
@Service
//@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public void account(){
        userDao.reduceMoney();
//        int a = 1/0;
        userDao.addMoney();

    }
}

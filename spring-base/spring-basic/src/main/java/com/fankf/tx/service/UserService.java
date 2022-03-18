package com.fankf.tx.service;

import com.fankf.tx.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * fankunfeng
 * 2020-09-12 23:53
 */
@Service
//@Transactional
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


    public void account(){
        logger.info("开始 ................");
//        userDao.reduceMoney();
//        int a = 1/0;
//        userDao.addMoney();
        logger.info("结束 ................");
    }
}

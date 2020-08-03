package com.fankf.springmvc;

import com.fankf.springmvc.dao.UserDao;
import com.fankf.springmvc.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringMvcApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(123);
        user.setUsername("2");
        int insert = userDao.insert(user);
    }

}

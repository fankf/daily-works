package com.fankf.springmvc;

import com.fankf.springmvc.entity.User;
import com.fankf.springmvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * fankunfeng
 * 2020-09-03 14:14
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        User user = new User();
        user.setAge(12);
        user.setUsername("zzzz");
        userService.insert(user);
    }

    @Test
    public void test0(){
        User user = new User();
        user.setId(3);
        user.setAge(11);
        user.setUsername("zzzz");
        userService.update(user);
    }


    @Test
    public void test1(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setAge(13);
        user.setUsername("zzzz");
        User user2 = new User();
        user2.setAge(131);
        user2.setUsername("zzzz");

        users.add(user);
        users.add(user2);
        userService.insertUsers(users);
    }

}

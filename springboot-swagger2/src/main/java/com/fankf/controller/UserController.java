package com.fankf.controller;

import com.fankf.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fankunfeng
 * 2020-09-15 10:59
 */
@Api(value = "UserController 简介")
@RestController
public class UserController {

    private List<User> user() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setAge(1);
        user.setUsername("zs");
        user.setId(1);

        User user1 = new User();
        user1.setAge(12);
        user1.setUsername("zs1");
        user1.setId(2);

        User user2 = new User();
        user2.setAge(13);
        user2.setUsername("zs2");
        user2.setId(3);

        User user3 = new User();
        user3.setAge(14);
        user3.setUsername("zs3");
        user3.setId(4);

        User user4 = new User();
        user4.setAge(15);
        user4.setUsername("zs4");
        user4.setId(5);

        users.addAll(Arrays.asList(user, user1, user2, user3, user4));
        return users;
    }

    @ApiOperation(value = "查询所有用户信息",httpMethod = "GET")
    @RequestMapping("/user")
    public List<User> userAll() {
        User user = new User();
        user.setAge(1);
        user.setUsername("zs");
        user.setId(1);
        return Arrays.asList(user);
    }
    @ApiOperation(value = "查询单个用户信息",httpMethod = "GET")
    @RequestMapping("/userOne")
    public User userOne() {
        User user = new User();
        user.setAge(1);
        user.setUsername("zs");
        user.setId(1);
        return user;
    }
}

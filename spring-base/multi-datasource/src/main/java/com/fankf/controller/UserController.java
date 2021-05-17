package com.fankf.controller;

import com.fankf.entity.User;
import com.fankf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fankunfeng
 * 2021-01-28 09:34
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query/{id}")
    public User getOne(@PathVariable Integer id){
        return userService.queryById(id);
    }

}

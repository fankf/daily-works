package com.fankf.controller;

import com.fankf.bean.User;
import com.fankf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * fankunfeng
 * 2020-09-16 22:00
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/{id}")
    public Mono<User> queryUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping("/users")
    public Flux<User> queryUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/insertUser")
    public Mono<Void> queryUserById(@RequestBody User user){
        return userService.insertUser(Mono.just(user));
    }
}

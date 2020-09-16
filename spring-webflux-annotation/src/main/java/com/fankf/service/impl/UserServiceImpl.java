package com.fankf.service.impl;

import com.fankf.bean.User;
import com.fankf.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * fankunfeng
 * 2020-09-16 22:01
 */
@Service
public class UserServiceImpl implements UserService {

    public final Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        this.userMap.put(1, new User("zhangsan", "nan", 12));
        this.userMap.put(2, new User("mary", "nv", 14));
        this.userMap.put(3, new User("lucy", "nv", 16));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.just(userMap.get(id));
    }

    @Override
    public Flux<User> getUsers() {
        return Flux.fromIterable(userMap.values());
    }

    @Override
    public Mono<Void> insertUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            userMap.put(userMap.size() + 1, user);
        }).thenEmpty(Mono.empty());
    }
}

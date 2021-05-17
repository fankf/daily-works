package com.fankf.service;

import com.fankf.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * fankunfeng
 * 2020-09-16 22:01
 */
public interface UserService {

    Mono<User> getUserById(int id);

    Flux<User> getUsers();

    Mono<Void> insertUser(Mono<User> userMono);
}

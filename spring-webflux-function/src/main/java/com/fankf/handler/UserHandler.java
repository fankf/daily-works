package com.fankf.handler;

import com.fankf.bean.User;
import com.fankf.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * fankunfeng
 * 2020-09-16 22:21
 */
public class UserHandler {

    private UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> queryUserById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        Mono<User> userById = userService.getUserById(id);
        return userById.flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(user))).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> queryUsers(ServerRequest request) {
        Flux<User> users = userService.getUsers();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        Mono<Void> voidMono = userService.insertUser(userMono);
        return ServerResponse.ok().build(voidMono);
    }
}

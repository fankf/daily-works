package com.fankf;

import com.fankf.handler.UserHandler;
import com.fankf.service.UserService;
import com.fankf.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * fankunfeng
 * 2020-09-16 22:37
 */
public class RouterServer {

    public static void main(String[] args) throws IOException {
        RouterServer server = new RouterServer();
        server.createRouterServer();
        System.out.println("server to exit ...");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routerFunction() {
        UserService userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);

        return RouterFunctions
                .route(GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::queryUserById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::queryUsers);

    }

    public void createRouterServer(){
        RouterFunction<ServerResponse> routerFunction = routerFunction();
        HttpHandler httpHandler = toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);

        // 服务器
        HttpServer server = HttpServer.create();
        server.handle(httpHandlerAdapter).bindNow();

    }
}

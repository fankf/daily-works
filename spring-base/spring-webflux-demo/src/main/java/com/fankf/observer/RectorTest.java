package com.fankf.observer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * fankunfeng
 * 2020-09-15 22:23
 */
public class RectorTest {

    public static void main(String[] args) {
        //just
        Flux.just(1,2,3,4);
        Mono.just(1);
    }
}

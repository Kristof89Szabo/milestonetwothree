package com.exam.reactive.r01mono;

import reactor.core.publisher.Mono;

public class Lec02MonoSubscribe {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just(5);

        // 1.
        mono.subscribe(integer -> System.out.println("Received: " + integer));

        // 2.
        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

    }
}

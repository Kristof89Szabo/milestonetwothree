package com.exam.reactive.mono;

import reactor.core.publisher.Mono;

public class Lec01MonoJust {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just(5); // just: if we have the data already
        mono.subscribe(integer -> System.out.println("Received: " + integer));

    }
}

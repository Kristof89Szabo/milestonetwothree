package com.exam.reactive.mono;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just("something")
                .map(i -> i.length())
                .map(i -> i / 0); //Going to throw an error.

        mono.subscribe(
                Util.onNext(),
                Util.onError(), // Catch error
                Util.onComplete()
        );

    }
}

package com.exam.reactive.r01mono;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(2)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().fullName());
        } else if (userId == 2) {
            return Mono.empty(); //Subscriber is going to ignore this empty and jump to onComplete.
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }

}

package com.exam.reactive.r01mono;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already
//        final Mono<String> mono = Mono.just(getName());

        //Only invokes if there is a subscriber!
        final Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().firstName();
    }

}

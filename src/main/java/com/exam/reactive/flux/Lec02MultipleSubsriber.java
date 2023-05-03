package com.exam.reactive.flux;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubsriber {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);

        flux.subscribe(i -> System.out.println("Sub1: " + i));
        flux.subscribe(i -> System.out.println("Sub2: " + i));

        //Even numbers from provider
        Flux<Integer> evenFlux = flux.filter(integer -> integer % 2 == 0);
        evenFlux.subscribe(integer -> System.out.println("Even flux: " + integer));


    }
}

package com.exam.reactive.flux;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

import static com.exam.reactive.util.Util.onComplete;
import static com.exam.reactive.util.Util.onError;
import static com.exam.reactive.util.Util.onNext;

public class Lec03FluxFromStream {


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = list.stream();


        //1, After we use the stream we can not reuse it.
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

        //2,
        Flux<Integer> integerFlux = Flux.fromStream(list::stream); //We are feeding the provider during the list to stream.

        integerFlux.subscribe(
                onNext(),
                onError(),
                onComplete()
        );

        integerFlux.subscribe(
                onNext(),
                onError(),
                onComplete()
        );

    }
}

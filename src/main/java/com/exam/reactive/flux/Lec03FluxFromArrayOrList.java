package com.exam.reactive.flux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static com.exam.reactive.util.Util.onNext;

public class Lec03FluxFromArrayOrList {


    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings)
                .subscribe(onNext());


        Integer[] array = {2, 3, 4, 5};
        Flux.fromArray(array)
                .subscribe(onNext());

    }
}

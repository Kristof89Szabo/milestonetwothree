package com.exam.reactive.flux;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        flux.subscribe(Util.onNext());

    }
}

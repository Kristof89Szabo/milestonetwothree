package com.exam.reactive.r02flux;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

import static com.exam.reactive.util.Util.onNext;

public class Lec04FluxRange {

    public static void main(String[] args) {
        //Two parameter: starting number, and how many times to repeat. (How many item will be published)
        Flux.range(1, 10).subscribe(onNext());

        //Let's give a few names to the subscribers.
        Flux.range(3, 10)
                .map(__ -> Util.faker().name().fullName())
                .subscribe(onNext());

    }
}

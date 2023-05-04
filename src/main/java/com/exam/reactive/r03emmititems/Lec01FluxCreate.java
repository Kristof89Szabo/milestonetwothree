package com.exam.reactive.r03emmititems;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        // 1,
//        Flux.create(fluxSink -> {
//                    fluxSink.next(1);
//                    fluxSink.next(3);
//                    fluxSink.next(5);
//                    fluxSink.complete();
//                }
//
//        ).subscribe(Util.subscriber());

        //2
//        Flux.create(fluxSink -> {
//                    for (int i = 0; i < 10; i++) {
//                        fluxSink.next(Util.faker().country().name());
//                    }
//                    fluxSink.complete();
//                }
//
//        ).subscribe(Util.subscriber());


        //3 - Random country name till we dont receive canada.
        Flux.create(fluxSink -> {

                    String country;

                    do {
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));
                    fluxSink.complete();
                }

        ).subscribe(Util.subscriber());

    }
}

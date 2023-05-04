package com.exam.reactive.r02flux;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Interval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)) //Publish item periodically.
                .subscribe(Util.onNext());


        Util.sleepSeconds(5);
    }

}

package com.exam.reactive.mono;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06Block {


    public static void main(String[] args) {
        String name = getName().subscribeOn(
                Schedulers.boundedElastic()) // It runs on new thread
                .block(); // It blocks the main thread
        System.out.println(name);

        getName();
        getName();
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");

        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}

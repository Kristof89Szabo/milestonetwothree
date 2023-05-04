package com.exam.reactive.r01mono;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Mono;

public class Lec05SupplierRefactoring {


    public static void main(String[] args) {
        getName(); // In this method to build a "pipeline" (Mono.from supplier) is not a big deal. To run the code inside it is.
        getName(); // When you subscribe to it, you will execute the inside code.
        getName().subscribe(
                Util.onNext() // This still runs on main thread
        );
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

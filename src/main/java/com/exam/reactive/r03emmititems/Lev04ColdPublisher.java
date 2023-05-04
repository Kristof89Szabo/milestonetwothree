package com.exam.reactive.r03emmititems;

import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lev04ColdPublisher {

    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2));


        movieStream.subscribe(Util.subscriber("Sam"));
        Util.sleepSeconds(5);

        movieStream.subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(60);

    }


    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of("1", "2", "3", "3", "5", "6", "7", "8", "9", "10");
    }

}

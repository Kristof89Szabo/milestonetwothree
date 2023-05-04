package com.exam.reactive.r03emmititems;

import com.exam.reactive.r03emmititems.helper.NameProducer;
import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxMultiThread {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());


        Runnable runnable = () -> nameProducer.produce();

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);

    }
}

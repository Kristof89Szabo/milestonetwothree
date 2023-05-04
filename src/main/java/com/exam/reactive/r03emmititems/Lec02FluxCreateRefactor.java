package com.exam.reactive.r03emmititems;

import com.exam.reactive.r03emmititems.helper.NameProducer;
import com.exam.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());


        nameProducer.produce();



    }
}

package com.exam.reactive.r02flux;

import com.exam.reactive.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec05Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Received Sub: " + s);
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("ontError: " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("Cancel subscription");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4); // When you cancel you can not get more item.
    }
}

package com.exam.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Tasker implements Runnable {
    private int id;

    public Tasker(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        //Single thread that will execute the tasks sequentially so one after another.
        //We have to shut down the executor.
        System.out.println("Task with id " + id + " is in work - thread id: " + Thread.currentThread());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //If we terminate a thread which sleeps -> we have to interrupt.
        }
    }
}

public class StoppingExecutor {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executor.execute(new Tasker(i));
        }

        //We prevent the executor to execute any further tasks.
        executor.shutdown();

        try {
            if (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) { //After shutDown we wait 1 sec. False is Executor service still running after 1 sec.
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}

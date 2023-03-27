package com.exam.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int id;

    public Task(int id) {
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
            throw new RuntimeException(e);
        }
    }
}

public class SingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executor.execute(new Tasker(i));
        }
        System.out.println("Main method");

    }
}

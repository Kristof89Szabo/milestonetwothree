package com.exam.designpatterns.behavioral_design_patterns.d12command.example2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Algorithm {

    private BlockingQueue<Command> commandsList;

    public Algorithm() {
        commandsList = new ArrayBlockingQueue<>(10);
    }

    public void produce() {
        try {
            for (int i = 0; i < 10; i++) {
                commandsList.put(new TaskSolver(new Task(i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                commandsList.take().execute();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

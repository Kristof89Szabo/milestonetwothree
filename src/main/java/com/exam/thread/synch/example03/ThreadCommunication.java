package com.exam.thread.synch.example03;

class Process {

    // Low level example

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again the produce method...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume method is executed....");
            notify();
        }
    }
}

public class ThreadCommunication {

    public static void main(String[] args) {
        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

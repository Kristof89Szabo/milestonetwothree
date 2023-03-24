package com.exam.thread.synch.example2;

public class s02AppWithSync {
    public static int counter = 0;

    //We make sure this method is executed only by a single thread at a given time with synchronized keyword.
    public static synchronized void increment() {
        counter++;
    }

    public static void process() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter is: " + counter);
    }

    public static void main(String[] args) {
        process();
    }

}

package com.exam.thread;

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}

public class RunnableMain {

    public static void main(String[] args) {
        //achive multi-threading (time slice Algorithm)
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        //Anonymous inner class.
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Runner3: " + i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

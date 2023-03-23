package com.exam.thread;

class Run1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class Run2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}

public class ThreadMain {

    public static void main(String[] args) {
        /*
        Two ways to create a thread.:
        - extends Thread, and we need to override the run method
        - implements Runnable

        Megvárni míg egy másik szál "lefusson" az  isAlive() metódussal tudjuk. Ekkor a Main szálunk várakozik.

         */
        Thread t1 = new Run1();
        Thread t2 = new Run2();
        t1.start();
        t2.start();


    }

}



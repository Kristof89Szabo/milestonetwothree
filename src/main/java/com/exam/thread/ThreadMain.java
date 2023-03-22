package com.exam.thread;

public class ThreadMain extends Thread {

    public static void main(String[] args) {
        /*
        Two ways to create a thread.:
        - extends Thread, and we need to override the run method
        - implements Runnable

        Megvárni míg egy másik szál "lefusson" az  isAlive() metódussal tudjuk. Ekkor a Main szálunk várakozik.

         */
        ThreadMain thread = new ThreadMain();
        thread.start();
        System.out.println("This code is outside of the thread");
    }

    @Override
    public void run() {
        System.out.println("This code is running in a thread");
    }

}



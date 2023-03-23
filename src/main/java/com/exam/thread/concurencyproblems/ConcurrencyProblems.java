package com.exam.thread.concurencyproblems;

public class ConcurrencyProblems extends Thread {

    /*
        Megvárni míg egy másik szál "lefusson" az  isAlive() metódussal tudjuk ( vagy join()). Ekkor a Main szálunk várakozik.
     */
    public static int amount = 0;

    public static void main(String[] args) {
        ConcurrencyProblems thread = new ConcurrencyProblems();
        thread.start();
        // Wait for the thread to finish
        while (thread.isAlive()) {
            System.out.println("Waiting...");
        }
        // Update amount and print the value
        System.out.println("Amount: " + amount);
        amount++;
        System.out.println("Amount: " + amount);
    }

    @Override
    public void run() {
        System.out.println("In thread");
        amount += 1;
    }

}

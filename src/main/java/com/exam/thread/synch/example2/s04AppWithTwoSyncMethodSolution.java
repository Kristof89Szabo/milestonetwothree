package com.exam.thread.synch.example2;

public class s04AppWithTwoSyncMethodSolution {

    public static int counter1 = 0;
    public static int counter2 = 0;

    // synchronized block. For static method we can not use "this" keyword.
    // we synchronize block that 100% necessary.
    public static void increment1() {
        //class level locking as well here. So not 100% good solution.
        synchronized (s04AppWithTwoSyncMethodSolution.class) {
            counter1++;
        }
        //other code comes here
    }

    public static synchronized void increment2() {
        synchronized (s04AppWithTwoSyncMethodSolution.class) {
            counter2++;
        }
        //other code comes here
    }

    public static void process() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment2();
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
        System.out.println("Counter is: " + counter1);
        System.out.println("Counter is: " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}

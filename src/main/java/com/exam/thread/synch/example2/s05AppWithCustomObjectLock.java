package com.exam.thread.synch.example2;

public class s05AppWithCustomObjectLock {

    public static int counter1 = 0;
    public static int counter2 = 0;

    // Two custom object to prevent to use Class lock. They will lock just this two object so
    // independently can increase this two value. Class object wont be locked.
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
        //other code comes here
    }

    public static synchronized void increment2() {
        synchronized (lock2) {
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

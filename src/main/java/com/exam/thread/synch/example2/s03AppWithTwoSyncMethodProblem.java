package com.exam.thread.synch.example2;

public class s03AppWithTwoSyncMethodProblem {

    public static int counter1 = 0;
    public static int counter2 = 0;

    //AppWithTwoSyncMethodProblem object gets 1 lock so increment2() has to wait till increment1() finishes.
    // Not good practice - We should use object level locking. (synchronized blocks)
    public static synchronized void increment1() {
        counter1++;
    }

    public static synchronized void increment2() {
        counter2++;
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

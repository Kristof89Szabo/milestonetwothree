package com.exam.thread.synch.example2;

public class s01AppWithoutSync {

    /*
    - It takes some time to finish with increment operation on 1 thread
    - During this procedure another thread may call this method as well with the original counter value.
     */

    public static int counter = 0;

    public static void process() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
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

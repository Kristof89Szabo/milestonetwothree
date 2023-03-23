package com.exam.thread.daemonthread;

class DaemonWorker implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("DeamonThread is running...");
        }
    }
}

class NormalWorker implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("NormalWorker thread finishes execution...");
    }
}

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonWorker());
        t1.setDaemon(true);
        Thread t2 = new Thread(new NormalWorker());

        t1.start();
        t2.start();
    }
}

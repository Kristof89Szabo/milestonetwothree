package com.exam.thread.synch;

public class SynchronizedMain {

    public static void main(String[] args) {
        Table obj1 = new Table();//only one object
        MyThread1 t1 = new MyThread1(obj1);
        MyThread2 t2 = new MyThread2(obj1);
        t1.start();
        t2.start();
    }

    public static class Table {

        synchronized void printTable(int n) {//method IS synchronized
            for (int i = 1; i <= 20; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static class MyThread1 extends Thread {

        Table t;

        MyThread1(Table t) {
            this.t = t;
        }

        @Override
        public void run() {
            t.printTable(5);
        }

    }

    public static class MyThread2 extends Thread {

        Table t;

        MyThread2(Table t) {
            this.t = t;
        }

        @Override
        public void run() {
            t.printTable(100);
        }

    }
}

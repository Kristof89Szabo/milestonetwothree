package com.exam.thread.executors;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {

    @Override
    public void run() {
        System.out.println("Updateing and downloading stock related data from web...");
    }
}

public class ScheduledThreadPool {

    public static void main(String[] args) {
        //Executor will call StockMarketUpdater every 5 seconds.
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 5000, TimeUnit.MILLISECONDS);

    }
}

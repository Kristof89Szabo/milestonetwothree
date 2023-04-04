package com.exam.designpatterns.behavioral_design_patterns.d12command.example2;

public class App {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();

        Thread t1 = new Thread(algorithm::produce);
        Thread t2 = new Thread(algorithm::consume);

        t1.start();
        t2.start();
    }
}

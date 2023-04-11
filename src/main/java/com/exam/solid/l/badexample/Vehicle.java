package com.exam.solid.l.badexample;

public class Vehicle {

    protected String type;
    protected int age;

    Vehicle(String type, int age) {
        this.type = type;
        this.age = age;
    }

    protected void speedUp() {
        System.out.println("Vehicle is speeding up...");
    }

    protected void slowDown() {
        System.out.println("Vehicle is slowing down...");
    }

    protected void fuel() {
        System.out.println("Vehicle fuel method...");
    }
}

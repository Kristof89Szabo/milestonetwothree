package com.exam.generics.nogen;

public class IntegerSender {

    Integer number;

    public IntegerSender(Integer number) {
        this.number = number;
    }

    public void send() {
        System.out.println("Send this: " + number);
    }

}

package com.exam.generics.yesgen;

public class Sender<T> {

    T value;

    public Sender(T value) {
        this.value = value;
    }

    public void send() {
        System.out.println("Send this: " + value);
    }

}

package com.exam.generics.yesgen;

public class Main {

    public static void main(String[] args) {

        Sender<Integer> integerSender = new Sender<>(6);
        Sender<String> stringSender = new Sender<>("dummytext");

        integerSender.send();
        stringSender.send();

    }
}

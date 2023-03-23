package com.exam.generics.nogen;

public class Main {

    public static void main(String[] args) {
        IntegerSender integerSender = new IntegerSender(7);
        StringSender stringSender = new StringSender("dummystring");

        integerSender.send();
        stringSender.send();
    }
}

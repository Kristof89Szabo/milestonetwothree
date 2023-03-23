package com.exam.generics.nogen;

public class StringSender {

    String str;

    public StringSender(String str) {
        this.str = str;
    }

    public void send() {
        System.out.println("Send this: " + str);
    }


}

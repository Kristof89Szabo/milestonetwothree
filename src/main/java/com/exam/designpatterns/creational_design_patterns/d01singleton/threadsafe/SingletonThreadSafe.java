package com.exam.designpatterns.creational_design_patterns.d01singleton.threadsafe;

public class SingletonThreadSafe {

    public static void main(String[] args) {
        Singleton s = Singleton.SINGLETON;
        Singleton s1 = Singleton.SINGLETON;

        if (s.equals(s1)) {
            System.out.println("Same....");
        }
    }


}

package com.exam.designpatterns.creational_design_patterns.d01singleton;

class SingletonEager {

    private static SingletonEager singletonEagar = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return singletonEagar;
    }

}

class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        SingletonEager singletonEager = SingletonEager.getInstance();
        System.out.println(singletonEager.hashCode());

        SingletonEager singletonEager1 = SingletonEager.getInstance();
        System.out.println(singletonEager1.hashCode());
    }

}


package com.exam.designpatterns.creational_design_patterns.d01singleton;

class SingletonEager {

    private static SingletonEager singletonEagar = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return singletonEagar;
    }

    public void eagerMethod() {
        System.out.println("I am a singleton eager");
    }

}

class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {

        //If we have more thread they will create more instance. -> synchronized() -> slow solution
        if (singletonLazy == null) {
            synchronized (SingletonLazy.class) {
                singletonLazy = new SingletonLazy();
            }
        }
        return singletonLazy;
    }

    public void lazyMethod() {
        System.out.println("I am a singleton lazy");
    }

}

public class SingletonExample {

    public static void main(String[] args) {
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();

        System.out.println(singletonEager1.hashCode());
        System.out.println(singletonEager2.hashCode());
        singletonEager1.eagerMethod();

        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singletonLazy.hashCode());
        System.out.println(singletonLazy2.hashCode());
        singletonLazy.lazyMethod();
    }

}


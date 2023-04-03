package com.exam.designpatterns.structural_design_patterns.d08decorator;

public class App {

    public static void main(String[] args) {

        Beverage beverage = new PlainBeverage();
        System.out.println(beverage.getCost() + beverage.getDescription());

        Beverage beverage1 = new Milk(new PlainBeverage());
        System.out.println(beverage1.getCost() + " " + beverage1.getDescription());

        Beverage beverage2 = new Sugar(new Milk(new Sugar(new PlainBeverage())));
        System.out.println(beverage2.getCost() + " " + beverage2.getDescription());


    }
}

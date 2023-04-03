package com.exam.designpatterns.structural_design_patterns.d08decorator;

public class Milk extends BeverageDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        //We sum up the costs.
        return beverage.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "milk.";
    }
}

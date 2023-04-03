package com.exam.designpatterns.structural_design_patterns.d08decorator;

public class Sugar extends BeverageDecorator{

    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "sugar ";
    }
}

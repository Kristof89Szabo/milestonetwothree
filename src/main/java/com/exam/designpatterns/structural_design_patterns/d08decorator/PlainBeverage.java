package com.exam.designpatterns.structural_design_patterns.d08decorator;

public class PlainBeverage implements Beverage{
    @Override
    public int getCost() {
        //All beverage start at 5;
        return 5;
    }

    @Override
    public String getDescription() {
        return "";
    }
}

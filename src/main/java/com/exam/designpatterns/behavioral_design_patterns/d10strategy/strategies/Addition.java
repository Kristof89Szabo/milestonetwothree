package com.exam.designpatterns.behavioral_design_patterns.d10strategy.strategies;

public class Addition implements Strategy {

    @Override
    public void execute(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}

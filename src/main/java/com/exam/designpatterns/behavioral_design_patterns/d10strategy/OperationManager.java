package com.exam.designpatterns.behavioral_design_patterns.d10strategy;

import com.exam.designpatterns.behavioral_design_patterns.d10strategy.strategies.Strategy;

// Abstract layer in between the high level modules and low level module
//OpManager does not know anything about strategy implementation
public class OperationManager {

    //We have to use composition cause behaviour can be changed at run-time
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int num1, int num2){
        strategy.execute(num1, num2);
    }
}

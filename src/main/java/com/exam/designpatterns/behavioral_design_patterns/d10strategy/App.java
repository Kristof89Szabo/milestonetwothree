package com.exam.designpatterns.behavioral_design_patterns.d10strategy;

import com.exam.designpatterns.behavioral_design_patterns.d10strategy.strategies.Addition;
import com.exam.designpatterns.behavioral_design_patterns.d10strategy.strategies.Multiplication;
import com.exam.designpatterns.behavioral_design_patterns.d10strategy.strategies.Substraction;

public class App {

    public static void main(String[] args) {

        OperationManager operationManager = new OperationManager();
        operationManager.setStrategy(new Addition());
        operationManager.execute(1, 3);

        operationManager.setStrategy(new Multiplication());
        operationManager.execute(2, 5);

        operationManager.setStrategy(new Substraction());
        operationManager.execute(9, 2);

    }
}

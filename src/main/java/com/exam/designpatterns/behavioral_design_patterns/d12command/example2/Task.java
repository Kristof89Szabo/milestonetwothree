package com.exam.designpatterns.behavioral_design_patterns.d12command.example2;

public class Task {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    public void solveProblem() {
        System.out.println("Solving the problem with id: " + id);
    }
}

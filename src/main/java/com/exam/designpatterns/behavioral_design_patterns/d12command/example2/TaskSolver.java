package com.exam.designpatterns.behavioral_design_patterns.d12command.example2;

public class TaskSolver implements Command {

    private Task task;

    public TaskSolver(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        this.task.solveProblem();
    }
}

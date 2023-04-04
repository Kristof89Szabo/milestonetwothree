package com.exam.designpatterns.behavioral_design_patterns.d12command.example1;

import java.util.ArrayList;
import java.util.List;

//Invoker
public class Switcher {
    public List<Command> commands;

    public Switcher() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }

}

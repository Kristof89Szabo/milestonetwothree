package com.exam.designpatterns.behavioral_design_patterns.d12command.example1;

public class App {

    public static void main(String[] args) {
        Switcher switcher = new Switcher();

        Light light = new Light();
        TurnOnCommand onCommand = new TurnOnCommand(light);
        TurnOffCommand offCommand = new TurnOffCommand(light);

        switcher.addCommand(onCommand);
        switcher.addCommand(offCommand);

        switcher.executeCommands();

    }
}

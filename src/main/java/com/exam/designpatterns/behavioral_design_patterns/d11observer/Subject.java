package com.exam.designpatterns.behavioral_design_patterns.d11observer;

public interface Subject {

    void addObserver(Observer observer);
    void removerObserver(Observer observer);
    void notifyAllObservers();
}

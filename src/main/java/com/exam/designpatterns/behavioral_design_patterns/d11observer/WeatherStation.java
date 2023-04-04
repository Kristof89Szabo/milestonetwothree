package com.exam.designpatterns.behavioral_design_patterns.d11observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private int pressure;
    private int temperature;
    private int humidity;
    List<Observer> observerList;

    public WeatherStation() {
        observerList = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update(pressure, temperature, humidity);
        }
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        notifyAllObservers();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAllObservers();
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyAllObservers();
    }
}

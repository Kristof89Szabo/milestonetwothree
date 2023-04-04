package com.exam.designpatterns.behavioral_design_patterns.d11observer;

public class App {

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherObserver observer = new WeatherObserver(station);

        station.setPressure(80);
        station.setTemperature(30);
        station.setHumidity(24);
    }
}

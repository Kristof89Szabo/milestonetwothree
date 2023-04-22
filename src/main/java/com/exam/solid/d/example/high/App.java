package com.exam.solid.d.example.high;

import com.exam.solid.d.example.mid.DatabaseFactory;

public class App {

    public static void main(String[] args) {

        DatabaseController controller = new DatabaseController(DatabaseFactory.create());
        controller.connect();
        controller.disconnect();

    }
}

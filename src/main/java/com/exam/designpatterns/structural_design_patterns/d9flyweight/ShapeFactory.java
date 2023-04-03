package com.exam.designpatterns.structural_design_patterns.d9flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    // We will create a rectangle for every color
    private final Map<String, Shape> shapes;

    public ShapeFactory() {
        shapes = new HashMap<>();
    }

    //Get a shape based on a given color
    public Shape getShape(String color) {
        if (shapes.containsKey(color)) {
            return shapes.get(color);
        }
        System.out.println("Creating a new rectangle");
        Shape shape = new Rectangle(color);
        shapes.put(color, shape);
        return shape;
    }
}

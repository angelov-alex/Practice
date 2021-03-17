package com.sap.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {

        return (2 * radius) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * radius;
    }
}

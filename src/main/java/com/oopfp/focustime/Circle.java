package com.oopfp.focustime;

public class Circle extends TopicDesc implements Shapes, Stringify{
    private Double radius;
    private Double height;

    public Circle(String name, String desc) {
        super(name, desc);
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public Double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double getPrism() {
        return getArea() * height;
    }

    @Override
    public String resultPrint() {
        return "Circle\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nTube Volume: " + getPrism();
    }
}

package com.oopfp.focustime;

// Circle class that extends the TopicDesc class and interface Shapes and Stringify
public class Circle extends TopicDesc implements Shapes, Stringify{
//    Two private attributes of a circle object
    private Double radius;
    private Double height;

//    Constructor with superclass attributes
    public Circle(String name, String desc) {
        super(name, desc);
    }

//    Setters
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

//    Methods from Shapes interface - getArea, getPerimeter, and getPrism
//    Override because formula is different for each shape
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

//    Method from Stringify interface
//    Override because it's different for every shapes
    @Override
    public String resultPrint() {
        return "Circle\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nTube Volume: " + getPrism();
    }
}

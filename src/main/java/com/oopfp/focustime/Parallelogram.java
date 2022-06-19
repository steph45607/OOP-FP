package com.oopfp.focustime;

// Parallelogram class that inherit TopicDesc class and Shapes and also Stringify interfaces
public class Parallelogram extends TopicDesc implements Shapes, Stringify{
    private Double base;
    private Double side;
    private Double parHeight;
    private Double height;

//    Constructor with superclass attributes
    public Parallelogram(String name, String desc) {
        super(name, desc);
    }

//    Setters
    public void setBase(Double base) {
        this.base = base;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public void setParHeight(Double parHeight) {
        this.parHeight = parHeight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    //    Methods from Shapes interface - getArea, getPerimeter, and getPrism
    //    Override because formula is different for each shape
    public Double getArea() {
        return base * parHeight;
    }

    @Override
    public Double getPerimeter() {
        return 2*(side*base);
    }

    @Override
    public Double getPrism() {
        return getArea() * height;
    }

    //    Method from Stringify interface
    //    Override because it's different for every shapes
    @Override
    public String resultPrint() {
        return "Parallelogram\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nParallelogram Prism Volume: " + getPrism();
    }
}

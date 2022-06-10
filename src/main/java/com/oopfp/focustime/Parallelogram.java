package com.oopfp.focustime;

public class Parallelogram extends TopicDesc implements Shapes, Stringify{
    private Double base;
    private Double side;
    private Double parHeight;
    private Double height;

    public Parallelogram(String name, String desc) {
        super(name, desc);
    }

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

    @Override
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

    @Override
    public String resultPrint() {
        return "Parallelogram\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nParallelogram Prism Volume: " + getPrism();
    }
}

package com.oopfp.focustime;

// Triangle class that inherit TopicDesc class and Shapes and also Stringify interfaces
public class Triangle extends TopicDesc implements Shapes, Stringify{
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double height;

    //    Constructor with superclass attributes
    public Triangle(String name, String desc) {
        super(name, desc);
    }

    //    Setters
    public void setSideA(Double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(Double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(Double sideC) {
        this.sideC = sideC;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    //    Methods from Shapes interface - getArea, getPerimeter, and getPrism
    //    Override because formula is different for each shape
    @Override
    public Double getArea() {
        Double semiPerimeter = (sideA+sideB+sideC)/2;
        return Math.sqrt(semiPerimeter*(semiPerimeter-sideA)*(semiPerimeter-sideB)*(semiPerimeter-sideC));
    }

    @Override
    public Double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public Double getPrism() {
        return getArea() * height;
    }

    //    Method from Stringify interface
    //    Override because it's different for every shapes
    @Override
    public String resultPrint() {
        return "Triangle\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nTriangular Prism Volume: " + getPrism();

    }
}

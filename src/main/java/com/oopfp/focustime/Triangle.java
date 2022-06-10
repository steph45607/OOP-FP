package com.oopfp.focustime;

public class Triangle extends TopicDesc implements Shapes, Stringify{
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double height;

    public Triangle(String name, String desc) {
        super(name, desc);
    }

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

    @Override
    public String resultPrint() {
        return "Triangle\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nTriangular Prism Volume: " + getPrism();

    }
}

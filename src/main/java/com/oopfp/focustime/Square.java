package com.oopfp.focustime;

// Square class that inherit TopicDesc class and Shapes and also Stringify interfaces
public class Square extends TopicDesc implements Shapes, Stringify{
    private Double width;
    private Double height;

    //    Constructor with superclass attributes
    public Square(String name, String desc){
        super(name, desc);
    }

    //    Setters
    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    //    Methods from Shapes interface - getArea, getPerimeter, and getPrism
    //    Override because formula is different for each shape
    @Override
    public Double getArea() {
        return width * width;
    }

    @Override
    public Double getPerimeter() {
        return 4 * width;
    }

    @Override
    public Double getPrism() {
        return getArea() * height;
    }

    //    Method from Stringify interface
    //    Override because it's different for every shapes
    @Override
    public String resultPrint(){
        return "Square\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nVolume: " + getPrism();
    }

}

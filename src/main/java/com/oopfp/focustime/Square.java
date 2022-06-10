package com.oopfp.focustime;

public class Square extends TopicDesc implements Shapes, Stringify{
    private Double width;
    private Double height;

    public Square(String name, String desc){
        super(name, desc);
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

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

    @Override
    public String resultPrint(){
        return "Square\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nVolume: " + getPrism();
    }

}

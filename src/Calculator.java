package src;

public class Calculator {
    public double computeArea(double length, double width) {
        Rectangle shape = new Rectangle(width, length);
        return shape.getArea();
    }
}

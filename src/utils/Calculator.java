package src.utils;

import src.Rectangle;
import src.Shape;
import src.Square;

public class Calculator {
    public double computeArea(double length, double width) {
        Shape shape = null;
        if (width == length) {
            shape = new Square(length);
        } else {
            shape = new Rectangle(width, length);
        }
        return shape.getArea();
    }
}

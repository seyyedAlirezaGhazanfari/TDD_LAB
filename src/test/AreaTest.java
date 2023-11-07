package src.test;

import org.junit.jupiter.api.Test;
import src.Calculator;
import src.Square;
import src.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTest {
    @Test
    public void getRectangleAreaTest() {
        double length = 3.2;
        double width = 2.5;
        Rectangle shape = new Rectangle(width, length);
        double result = shape.getArea();
        assertEquals(result, length * width);
        length = 5.6;
        width = 2;
        shape.setWidth(width);
        shape.setLength(length);
        result = shape.getArea();
        assertEquals(result, length * width);
    }

    @Test
    public void getSquareAreaTest() {
        double length = 3;
        Square shape = new Square(length);
        double actual = length * length;
        assertEquals(actual, shape.getArea());
        length = 5;
        shape.setLength(length);
        actual = length * length;
        assertEquals(actual, shape.getArea());
    }

    @Test
    public void computeAreaTest() {
        double length = 9;
        double width = 4.0;
        double actual = length * width;
        double predict = (new Calculator()).computeArea(length, width);
        assertEquals(predict, actual);

        length = 12;
        actual = length * length;
        predict = (new Calculator()).computeArea(length, length);
        assertEquals(predict, actual);
    }
}

package src.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.Calculator;
import src.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTest {
    @Test
    public void getAreaTest() {
        double length = 3.2;
        double width = 2.5;
        Rectangle shape = new Rectangle(width, length);
        double result = shape.getArea();
        assertEquals(result, length * width);
    }

    @Test
    public void computeAreaTest() {
        double length = 9;
        double width = 4.0;
        double actual = length * width;
        double predict = (new Calculator()).computeArea(length, width);
        assertEquals(predict, actual);
    }
}

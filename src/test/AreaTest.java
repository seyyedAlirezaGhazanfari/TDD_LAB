package src.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTest {
    @Test
    public void getAreaTest() {
        Rectangle shape = new Rectangle();
        double length = 3.2;
        double width = 2.5;
        shape.setWidth(width);
        shape.setLength(length);
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

package src.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import src.Rectangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTest {
    @Test
    public void computeAreaTest() {
        Rectangle shape = new Rectangle();
        double length = 3.2;
        double width = 2.5;
        shape.setWidth(width);
        shape.setLength(length);
        double result = shape.getArea();
        assertEquals(result, length * width);
    }
}

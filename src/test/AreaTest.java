package src.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaTest {

    private Rectangle shape;

    public AreaTest() {
        this.shape = null;
    }

    @BeforeAll
    private void createCalculator() {
        this.shape = new Rectangle();
    }

    @Test
    public void computeAreaTest(float length, float width) {
        this.shape.setWidth(width);
        this.shape.setLength(length);
        double result = this.shape.getArea();
        assertEquals(result, length * width);
    }
}

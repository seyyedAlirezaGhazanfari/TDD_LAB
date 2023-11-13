package src;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.length * this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}

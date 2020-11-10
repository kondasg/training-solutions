package numbers;

public class Circle {
    private final int diameter;
    private final double PI = 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return 2 * diameter * PI;
    }

    public double area() {
        return diameter * diameter * PI;
    }
}

package week10d01;

public class Elevation {

    private final double plus;
    private final double minus;

    public Elevation(double plus, double minus) {
        this.plus = plus;
        this.minus = minus;
    }

    public double getPlus() {
        return plus;
    }

    public double getMinus() {
        return minus;
    }

    @Override
    public String toString() {
        return "Elevation{" +
                "plus=" + plus +
                ", minus=" + minus +
                '}';
    }
}

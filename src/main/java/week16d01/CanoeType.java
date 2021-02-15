package week16d01;

public enum CanoeType {

    RED(1), GREEN(1.2), BLUE(1.5);

    private final double multiplier;

    CanoeType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}

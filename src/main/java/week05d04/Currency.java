package week05d04;

public enum Currency {

    HUF(1.0),
    USD (300.0);

    private final double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}

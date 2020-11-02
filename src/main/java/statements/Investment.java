package statements;

public class Investment {
    private final double cost = 0.3;
    private final int fund;
    private final int interestRate;
    private final boolean active = true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return 0;
    }

    public double close(int days) {
        return 0;
    }

}

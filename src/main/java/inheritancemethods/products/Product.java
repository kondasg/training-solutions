package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private final String name;
    private final BigDecimal unitWeight;
    private final int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this(name, unitWeight, 2);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces) {
        return unitWeight.multiply(new BigDecimal(pieces)).setScale(numberOfDecimals, RoundingMode.HALF_UP);
    }
}

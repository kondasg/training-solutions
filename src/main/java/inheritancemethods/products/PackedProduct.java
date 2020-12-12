package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {

    private final int packingUnit;
    private final BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int box = (pieces / packingUnit) + 1;
        return super.getUnitWeight().multiply(new BigDecimal(pieces)).add(weightOfBox.multiply(new BigDecimal(box))).setScale(super.getNumberOfDecimals(), RoundingMode.HALF_UP);
    }
}

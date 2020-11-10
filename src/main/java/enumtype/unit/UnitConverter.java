package enumtype.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        return length.multiply(new BigDecimal(source.getMm())).divide(new BigDecimal(target.getMm()));
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> l = new ArrayList<>();
        for (LengthUnit i : LengthUnit.values()) {
            if (i.isSi()) l.add(i);
        }
        return l;
    }
}

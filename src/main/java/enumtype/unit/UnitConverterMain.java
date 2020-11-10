package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(new BigDecimal(120), LengthUnit.CM, LengthUnit.M));
        System.out.println(unitConverter.convert(new BigDecimal(3), LengthUnit.M, LengthUnit.M));
        System.out.println(unitConverter.convert(new BigDecimal(15), LengthUnit.FOOT, LengthUnit.CM));

        System.out.println(unitConverter.siUnits());
    }
}

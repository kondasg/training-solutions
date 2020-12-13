package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double totalValue(List<Valued> valueds) {
        double sum = 0;
        for (Valued item: valueds) {
            sum += item.getValue();
        }
        return sum;
    }
}

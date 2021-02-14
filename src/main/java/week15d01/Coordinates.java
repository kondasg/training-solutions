package week15d01;

import java.util.Map;

public class Coordinates {

    public Map.Entry<Double, Double> functionMaximum(Map<Double, Double> coordinates) {
        if (coordinates.isEmpty()) {
            throw new IllegalArgumentException("Wrong param");
        }
        Map.Entry<Double, Double> maxElement = null;

        for (Map.Entry<Double, Double> actual : coordinates.entrySet()) {
            if (maxElement == null || maxElement.getValue() < actual.getValue()) {
                maxElement = actual;
            }
        }
        return maxElement;
    }
}

// Mai Junior feladat!
// Adott egy függvénygrafikon a koordináta rendszerben.
// A grafikon néhány pontját megkapjuk egy Map-ben.
// A map kulcsa az x koordináta értéke pedig az y koordináta.
// Döntsük el, hogy a kapott pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke.
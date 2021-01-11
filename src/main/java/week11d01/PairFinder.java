package week11d01;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    List<NumCount> numCounts = new ArrayList<>();

    public int findPairs(int[] arr) {
        for (int num: arr) {
            boolean include = false;
            for (NumCount n: numCounts) {
                if (n.getNumber() == num) {
                    n.setCount();
                    include = true;
                }
            }
            if (!include) {
                numCounts.add(new NumCount(num));
            }
        }
        return pairs();
    }

    public int pairs() {
        int pair = 0;
        for (NumCount item: numCounts) {
            if (item.getCount() > 1) {
                pair += item.getCount() / 2;
            }
        }
        return pair;
    }
}

// Mai senior feladat:
// Készítsünk egy PairFinder nevű osztályt, melynek van egy int findPairs(int[] arr) metódusa.
// A feladat az, hogy a tömb elemeiből kikeressük, hogy hány darab pár van bennük.
// Ha egy szám kétszer szerepel a tömbben, akkor az egy párnak számít.
// Példa: A [5, 1, 4, 5] tömbben kétszer szerepel az 5, ezért a visszatérési érték 1. A [7, 1, 5, 7, 3, 3, 9, 7, 6, 7]
// tömbben négyszer szerepel a 7, ezért ez 2 párnak számít, illetve a 3 kétszer szerepel, így a visszatérési érték 3.
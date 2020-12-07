package week07d01;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static long fib2(int n) { // saját
        if (n<0) {
            throw new IllegalArgumentException();
        }
        List<Integer> fibList = new ArrayList<>();
        fibList.add(0);
        fibList.add(1);
        if (n == 0) return fibList.get(0);
        if (n == 1) return fibList.get(1);
        for (int i = 2; i < n+1; i++) {
            fibList.add(fibList.get(i-2) + fibList.get(i-1));
        }
        return fibList.get(n);
    }

    private static final Long[] RESULTS = new Long[20000];

    public static long fib(int n) { // rekurzio Ádám
        if (n<0) {
            throw new IllegalArgumentException();
        }
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (RESULTS[n] == null) {
            RESULTS[n] = fib(n - 2) + fib(n - 1);
        }
        return RESULTS[n];
    }

}

//        Készíts egy osztályt a week07d01 csomagba Fibonacci néven. Legyen benne egy fib metódus, ami egy int n paramétert vár.
//        A visszatérési értékünk legyen egy long szám, ami az n-edik fibonacci számot tartalmazza.
//        (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az 1, 1.
//        Bónusz feladat: implementáljuk az algoritmust ciklus nélkül és mentsük el a részeredményeket egy statikus változóba.
//        Pontosítás: Ha n = 0, akkor 0-t adunk vissza, ha n=1, akkor 1-et, ezért lesz a 2. elem szintén 1, mert 0 + 1 = 1
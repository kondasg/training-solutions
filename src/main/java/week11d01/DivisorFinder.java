package week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        String s =  Integer.toString(n);
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            if (n % Integer.parseInt(s.substring(i, i+1)) == 0) {
                d++;
            }
        }
        return d;
    }

}

// Mai junior/mid-level feladat:
// Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa.
// A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak,
// majd számoljuk össze őket. Példa: a 425-ben az 5 osztója a számnak, ezért a visszatérési érték 1.

package week07d02;

public class DigitSum {

    public int sumOfDigits(int x) {
        String s = x + "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i+1));
        }
        return sum;
    }
}

// Készíts egy week07d02.DigitSum osztályt és benne sumOfDigits(int x) metóódus
// mely visszaadja a paraméterül kapott szám számjegyeinek összegét!
// pl.: 123 esetén a visszatérési érték 6.
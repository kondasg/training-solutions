package week08d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int a, int b) {
        if (a < b) {
            int c = b;
            b = a;
            a = c;
        }
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new MathAlgorithms().greatestCommonDivisor(12, 68));
    }
}

// Junior
//
// A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor(),
// ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.
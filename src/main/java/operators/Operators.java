package operators;

public class Operators {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public int multiplyByPowerOfTwo(int a, int b) {
        return Integer.parseInt(Integer.toBinaryString(a << b ), 2);
    }
}

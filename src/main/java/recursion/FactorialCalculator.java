package recursion;

public class FactorialCalculator {

    public long getFactorial(int num) {
        if(num > 1) {
            long solution = getFactorial(num - 1);
            return num * solution;
        } else {
            return 1;
        }
    }
}

package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            int size = coefficients.length;
            double[] result = new double[size];
            for (int i = 0; i < size; i++) {
                result[i] = Double.parseDouble(coefficients[i]);
            }
            this.coefficients = result;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        } catch (IllegalArgumentException iae) {
            System.out.println("For input string: \"a\"");
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x, (double) n - j);
        }
        return sum;
    }
}

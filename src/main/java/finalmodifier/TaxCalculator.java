package finalmodifier;

public class TaxCalculator {
    private final int AFA = 27;

    public double tax(double price) {
        return price * (27 / 100.0);
    }

    public double priceWithTax(double price) {
        return price + tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println("100 ÁFA étéke: " + taxCalculator.tax(100));
        System.out.println("2110 ÁFA étéke: " + taxCalculator.tax(2110));

        System.out.println("200 bruttó: " + taxCalculator.priceWithTax(200));
        System.out.println("1230 bruttó: " + taxCalculator.priceWithTax(1230));

    }
}

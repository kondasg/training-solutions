package week05d04;

public class Product {

    private final long price;
    private final String currency;

    public Product(long price, String currency) {
        int okCurrency = 0;
        for (Currency c: Currency.values()) {
            if (currency.equals(c.name())) okCurrency = 1;
        }
        if (okCurrency < 1) throw new IllegalArgumentException("Nem létező currency");
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(String currency) {

        return price / Currency.valueOf(currency).getRate();
    }



}

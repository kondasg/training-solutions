package week05d04;

public class Product {

    private final long price;
    private final String currency;

    public Product(long price, String currency) {
        boolean okCurrency = true;
        for (Currency c: Currency.values()) {
            if (currency.equals(c.name())) okCurrency = false;
        }
        if (okCurrency) throw new IllegalArgumentException("Nem létező currency");
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(String currency) {

        return price / Currency.valueOf(currency).getRate();
    }

/*
Készíts egy osztályt Product néven, melynek van egy price (long) és egy currency (String) mezője.
A Product a konstruktorában ellenőrizze a currency mezőt, melynek az értéke vagy HUF, vagy USD lehet.
Készíts egy metódust convertPrice néven, melynek egy paramétere van (currency) és visszaadja a currency-nek megfelelő összeget (double).
Használjunk 300 forintos átváltási árfolyamot!

Példa: ha a Product-ot létrehozzuk a következőképp: new Product(150, "HUF"),
majd meghívjuk a convertPrice-ot "USD" paraméterrel, akkor az elvárt visszatérési érték 0.5.

Bónusz feladat: írjunk teszteket
Bónusz feladat 2: Használjunk enum-ot String helyett a pénznem reprezentációjára
 */

}

package introinheritance.basket;

public class ShoppingBasket {

    private final Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0;
        for (Item item: basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    } // az összes tételre

    public double sumTaxValue() {
        double sum = 0;
        for (Item item: basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }  // az összes tételre

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    } // befejezzük a vásárlást, a kosár ürítése

    public void removeMostExpensiveItem() {
        String remove = "";
        double mostExpensive = 0;
        for (Item item: basket.getItems()) {
            if ( mostExpensive < item.getNettoPrice() + item.getTaxAmount() ) {
                remove = item.getBarcode();
            }
        }
        basket.removeItem(remove);
    } // kikeresi és eltávolítja a kosárból a legdrágább tételt
}

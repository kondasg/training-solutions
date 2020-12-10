package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        Item remove = null;
        for (Item item: items) {
            if (barcode.equals(item.getBarcode())) {
                remove = item;
            }
        }
        items.remove(remove);
    }

    public void clearBasket()  {
        items.clear();
    } //a Basket ürítése

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }  // az Item lista másolatát adja vissza!
}

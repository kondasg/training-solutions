package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        Item item = findItem(name);
        if ( item == null) {
            items.add(new Item(name, quantity));
        }
        else {
            item.addQuantity(quantity);
        }

    }

    public int getItem(String name) {
        Item item = findItem(name);
        return item == null ? 0 : item.getQuantity();
    }

    private Item findItem(String name) {
        for (Item item: items) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    /*
    A mai senior feladat: week06d4.ShoppingCart osztályba dolgozz!
    Legyen egy addItem(String name, int quantity) metódusa, mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége).
    Az adatokat egy Item listába tárolja. Amennyiben már benne van az adott termék, ne újonnan vegye fel,
     hanem adja hozzá a mennyiséget a már felvett tételhez.
     Lehessen visszakérdezni név alapján a felvett mennyiséget a getItem(String name): int metódussal.
     Ha nem szerepel benne, 0 értéket adjon vissza. A teszt eseteket ne feledd!
    */
}

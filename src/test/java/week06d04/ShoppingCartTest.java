package week06d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    void itemNotExists() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("a", 5);
        assertEquals(5, shoppingCart.getItem("a"));
    }

    @Test
    void itemExists() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("a", 5);
        shoppingCart.addItem("a", 5);
        assertEquals(10, shoppingCart.getItem("a"));
    }

    @Test
    void moreExists() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("a", 5);
        shoppingCart.addItem("c", 5);
        assertEquals(5, shoppingCart.getItem("a"));
        assertEquals(5, shoppingCart.getItem("c"));
    }
}

package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingListTest {

    @Test
    void Test() {
        assertEquals(420, new ShoppingList().calculateSum("list.txt"));
    }
}

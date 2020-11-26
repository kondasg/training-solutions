package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void Test(){
        Product product = new Product(150, "HUF" );
        assertEquals(0.5, product.convertPrice("USD") );
    }



}

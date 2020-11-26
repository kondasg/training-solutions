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

    @Test
    void Test2(){
        Product product = new Product(1, "HUF" );
        assertEquals(1.0, product.convertPrice("HUF") );
    }

    @Test
    void Test3(){
        Product product = new Product(600, "HUF" );
        assertEquals(2.0, product.convertPrice("USD") );
    }



}

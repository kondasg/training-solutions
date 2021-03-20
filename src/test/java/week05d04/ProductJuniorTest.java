package week05d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductJuniorTest {

    @Test
    void testCreate() {
        ProductJunior product = new ProductJunior("kenyér", 2021, 3, 18);
        assertEquals("kenyér", product.getName());
        assertEquals(LocalDate.of(2021, 3, 18), product.getExp());
    }

}
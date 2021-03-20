package week05d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store();

    @Test
    void addProduct() {
        store.addProduct(new ProductJunior("kenyér", 2021, 3, 18));
        store.addProduct(new ProductJunior("vaj", 2022, 3, 22));
        store.addProduct(new ProductJunior("tej", 2021, 3, 11));
        store.addProduct(new ProductJunior("májkrém", 2050, 1, 1));
        assertEquals(4, store.getProducts().size());
    }

    @Test
    void getNumberOfExpired() {
        store.addProduct(new ProductJunior("kenyér", 2021, 3, 18));
        store.addProduct(new ProductJunior("vaj", 2022, 3, 22));
        store.addProduct(new ProductJunior("tej", 2021, 3, 11));
        store.addProduct(new ProductJunior("májkrém", 2050, 1, 1));
        assertEquals(2, store.getNumberOfExpired());
    }
}
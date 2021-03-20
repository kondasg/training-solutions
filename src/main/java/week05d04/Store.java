package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<ProductJunior> products = new ArrayList<>();

    public List<ProductJunior> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(ProductJunior product) {
        products.add(product);
    }

    public int getNumberOfExpired() {
        int result = 0;
        for (ProductJunior product : products) {
            if (product.getExp().isBefore(LocalDate.now())) {
                result++;
            }
        }
        return result;
    }
}

package classsctructureconstructors;

public class Store {
    String product;
    int stock;

    public Store(String product) {
        this.product = product;
    }

    public void store() {
        stock++;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void dispatch() {
        stock--;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

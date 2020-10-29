package classsctructureconstructors;

public class Store {
    String product;
    int stock = 0;

    public Store(String product) {
        this.product = product;
    }

    public void store(int darab) {
        stock+=darab;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void dispatch(int darab) {
        stock-=darab;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

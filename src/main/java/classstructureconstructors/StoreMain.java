package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("Vonalzó");
        store.store(5);
        System.out.println(store.getProduct() + ": " + store.getStock());

        Store store2 = new Store("Ceruza");
        store2.dispatch(10);
        System.out.println(store2.getProduct() + ": " + store2.getStock());
    }
}

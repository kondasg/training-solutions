package classsctructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("Vonalzó");
        store.store();
        System.out.println(store.getProduct() + ": " + store.getStock());

        Store store2 = new Store("Ceruza");
        store2.dispatch();
        System.out.println(store2.getProduct() + ": " + store2.getStock());
    }
}

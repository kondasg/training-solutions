package week02;

public class Product {
    private final String name;
    private final String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {
        return name.equals(p.getName());
    }

    public static void main(String[] args) {
        Product product1 = new Product("alma", "123");
        Product product2 = new Product("alma", "1234");
        Product product3 = new Product("alma2", "123");

        System.out.println("product1 és product2 egyenlő? "+ product1.areTheyEqual(product2));
        System.out.println("product1 és product3 egyenlő? "+ product1.areTheyEqual(product3));
        System.out.println("product2 és product3 egyenlő? "+ product2.areTheyEqual(product3));
    }
}

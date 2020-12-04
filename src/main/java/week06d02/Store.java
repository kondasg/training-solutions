package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public List<CategoryCounter> getProductsByCategory() {
        List<CategoryCounter> result = new ArrayList<>();
        for (Product product: products) {
            if (!containsCategory(result, product.getCategory())) {
                result.add(new CategoryCounter(product.getCategory()));
            }
        }
        return result;
    }

    public boolean containsCategory(List<CategoryCounter> categories, Category category) {
        for (CategoryCounter cc: categories) {
            if (cc.getCategory() == category) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Product> p = new ArrayList<>();
        p.add(new Product("kenyer", Category.BAKEDGOODS, 100));
        p.add(new Product("zsemle", Category.BAKEDGOODS, 10));
        p.add(new Product("kifli", Category.BAKEDGOODS, 20));
        p.add(new Product("tej", Category.DAIRY, 200));
        p.add(new Product("kefir", Category.BAKEDGOODS, 10));
        p.add(new Product("jég", Category.FROZEN, 50));
        Store store = new Store(p);

        System.out.println(store.getProductsByCategory());
    }
}

//    Hozz létre egy week06d02.Product osztályt melynek adattagjai a név, kategória és ár.
//    A kategória legyen enum FROZEN,DAIRY,BAKEDGOODS,OTHER felsorolókkal.
//    Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
//    Legyen egy getProductsByCategory() aminek az lényége, hogy visszaadja valamilyen adatszerkezetben,
//    hogy melyik kategóriából hány darab van a listában.
//    A "valamilyen adatszerkezet" a kreativításodra van bízva, az a lényeg,
//    hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van.
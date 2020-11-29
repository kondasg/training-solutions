package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    List<String> menu;
    String name;
    int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = numberOfTables * 4;
        this.menu = addMenu();
    }

    public List<String> addMenu() {
        List<String> menu = new ArrayList<>();
        menu.add("A");
        menu.add("B");
        menu.add("V");
        menu.add("H");
        menu.add("A");
        return menu;
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Étterem 1", 15);

        System.out.println(restaurant);
    }
}

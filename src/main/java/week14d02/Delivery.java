package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Delivery {

    private final Map<String, List<String>> shoppingList = new HashMap<>();

    public void loadFile(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                String[] products = splittedLine[1].split(",");
                List<String> productList = new ArrayList<>(Arrays.asList(products));
                shoppingList.put(splittedLine[0], productList);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        }
    }

    public List<String> findId(String id) {
        if (shoppingList.containsKey(id)) {
            List<String> productList = shoppingList.get(id);
            productList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return productList;
        } else {
            throw new IllegalArgumentException("The id: " + id + " not found");
        }
    }

    public int countProductByName(String product) {
        int count = 0;
        for (String key : shoppingList.keySet()) {
            if (shoppingList.get(key).contains(product)) {
                count++;
            }
        }
        return count;
    }

    public int countProductById(String id) {
        if (shoppingList.containsKey(id)) {
            return shoppingList.get(id).size();
        } else {
            throw new IllegalArgumentException("The id: " + id + " not found");
        }
    }

    public Map<String, Integer> countProductInFile() {
        Map<String, Integer> result = new HashMap<>();
        for (String key : shoppingList.keySet()) {
            for (String product : shoppingList.get(key)) {
                if (result.containsKey(product)) {
                    result.put(product, result.get(product) + 1);
                } else {
                    result.put(product, 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        delivery.loadFile("bevasarlolista.txt");
        System.out.println(delivery.findId("W34111"));
        System.out.println(delivery.countProductByName("cheese"));
        System.out.println(delivery.countProductById("C123"));
        System.out.println(delivery.countProductInFile());
    }
}

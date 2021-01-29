package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream outputStream, List<String> shoppingList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (String item : shoppingList) {
                bufferedWriter.write(item + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
        return result;
    }
}

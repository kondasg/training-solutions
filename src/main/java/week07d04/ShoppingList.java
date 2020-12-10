package week07d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShoppingList {

    public long calculateSum(String path) {
        Path file = Path.of(path);
        long sum = 0;
        try {
            List<String> lines = Files.readAllLines(file);
            for (String line: lines) {
                String[] s = line.split(";");
                sum += Long.parseLong(s[1]) * Long.parseLong(s[2]);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sum;

    }


}

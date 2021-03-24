package week07d04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShoppingList {

    public long calculateSum(String path) {
        Path file = Path.of("src/main/resources/week07d04/" + path);
        long sum = 0;
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String line: lines) {
                long result = calculateLine(line);
                sum += result;
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sum;

    }

    public long calculateLine(String line) {
        String[] s = line.split(";");
        long amount = Long.parseLong(s[1]);
        long price = Long.parseLong(s[2]);
        return amount * price;
    }

}

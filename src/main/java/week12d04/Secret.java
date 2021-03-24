package week12d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {

    public void readFile(String fileName) {
        Path file = Path.of(fileName);

        try {
            byte[] bytes = Files.readAllBytes(file);
            for (byte item: bytes) {
                System.out.print((char)(item + 10));
            }
        }
        catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public static void main(String[] args) {
        new Secret().readFile("src/main/resources/week12d04/secret.dat");
    }
}

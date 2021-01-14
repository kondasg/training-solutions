package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            Path file = Path.of(String.format("numbers%02d.txt", i));
            if (Files.isRegularFile(file)) {
                sum += numberOnFile(file);
            }
        }
        return sum;
    }

    public int numberOnFile(Path file) {
        try {
            String content = Files.readString(file);
            return Integer.parseInt(content);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FilesSum().sumNumbers());
    }
}

// Mai junior/mid level feladat:
// Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
// Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
// számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
// Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály sumNumbers() metódusába dolgozz!

package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers() {
        int sum = 0;
        String fileName;
        for (int i = 0; i < 100; i++) {
            if (i < 10) {
                fileName = "numbers0" + i + ".txt";
            } else {
                fileName = "numbers" + i + ".txt";
            }
            Path file = Path.of(fileName);
            sum += numberOnFile(file);
        }
        return sum;
    }

    public int numberOnFile(Path file) {
        if (Files.isRegularFile(file)) {
            try {
                String content = Files.readString(file);
                return Integer.parseInt(content);
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file", ioe);
            }
        }
        return 0;
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

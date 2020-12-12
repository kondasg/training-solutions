package week07d05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private final Scanner scanner;

    // Dependenxy injection
    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Kérm a(z) " + (i + 1) + ". sort: ");
            lines.add(scanner.nextLine());
        }
        return lines;
    }

    private Path readFilename() {
        System.out.println("Kérem a file nevet: ");
        String outputFile = scanner.nextLine();
        Path path = Path.of(outputFile);
        return path;
    }

    public void write(Path path, List<String> lines) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String s: lines) {
                writer.write(s + "\n");
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLines();

        Path file = saveInput.readFilename();

        saveInput.write(file, lines);
    }
}

// Kérj be a felhasználótól három sort, majd a fájl nevét.
// Mentsd el a sorokat ebbe a fájlba. A week07d05.SaveInput osztályba dolgozz!
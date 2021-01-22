package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlReader {

    public int readWord(Path file, String word) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(word)) {
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new HtmlReader().readWord(Path.of("index_hu.html"), "koronavírus"));
    }
}

// Mai junior/mid feladat:
// Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány!
// Másold be a projektedbe (index.html) néven! Ez egy szöveges állomány.
// Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!

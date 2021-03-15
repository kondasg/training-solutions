package week12d05;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class HtmlReader {

    public int readWord(BufferedReader br, String word) {
        try {
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
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(HtmlReader.class.getResourceAsStream("index_hu.html")))) {
            System.out.println(new HtmlReader().readWord(reader, "koronavírus"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Mai junior/mid feladat:
// Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány!
// Másold be a projektedbe (index.html) néven! Ez egy szöveges állomány.
// Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!

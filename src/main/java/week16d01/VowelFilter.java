package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VowelFilter {

    private static final List<Character> VOWELS
            = List.of('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');
    private final List<String> input = new ArrayList<>();
    private final List<String> output = new ArrayList<>();

    public List<String> filterFowels(BufferedReader reader) {
        loadFile(reader);
        for (String word : input) {
            newWord(word);
        }
        return output;
    }

    private void loadFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Read error", e);
        }
    }

    private void newWord(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (!VOWELS.contains(word.charAt(i))) {
                newWord.append(word.charAt(i));
            }
        }
        output.add(newWord.toString());
    }

    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("VowelFilter.txt"))) {
            System.out.println(new VowelFilter().filterFowels(br));
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }
}

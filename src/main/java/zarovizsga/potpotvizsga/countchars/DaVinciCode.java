package zarovizsga.potpotvizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaVinciCode {

    private final static List<Character> ALLOWED = List.of('0', '1', 'x');

    public int encode(String path, char part) {
        if (!ALLOWED.contains(part)) {
            throw new IllegalArgumentException();
        }
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            int countChar = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                countChar = countChar(part, countChar, line);
            }
            return countChar;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int countChar(char part, int countChar, String line) {
        char[] input = line.toCharArray();
        for (char c : input) {
            if (c == part) {
                countChar++;
            }
        }
        return countChar;
    }

}

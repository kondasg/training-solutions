package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharCounter {

    private static final List<Character> HUNGARY_ALPHABET = Arrays.asList('a', 'á', 'b', 'c', 'd', 'e', 'é', 'f', 'g', 'h',
            'i', 'í', 'j', 'k', 'l', 'm', 'n', 'o', 'ó', 'ö', 'ő', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'ü', 'ű', 'v', 'w', 'x', 'y', 'z');
    private static final List<Character> VOWELS = Arrays.asList('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');
    private static final List<Character> NON_VOWELS = new ArrayList<>(HUNGARY_ALPHABET);

    static {
        NON_VOWELS.removeAll(VOWELS);
    }

    public Result counter(BufferedReader reader) {
        try {
            Result result = new Result();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                for (int c = 0; c < line.length(); c++) {
                    char readChar = line.charAt(c);
                    if (VOWELS.contains(readChar)) {
                        result.incVowels();
                    } else if (NON_VOWELS.contains(readChar)) {
                        result.incNonVowels();
                    } else if (readChar == ' ') {
                        result.incSpaces();
                    } else {
                        result.incOthers();
                    }
                }
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

}

// Senior
//
// Számoljuk össze, hogy egy fájlban hány mássalhangzó, hány magánhangzó és hány egyéb karakter van.
// A space-eket ne vegyük figyelembe! A kis- és nagybetű különbség nem számít!

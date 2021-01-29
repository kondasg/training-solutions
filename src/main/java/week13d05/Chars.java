package week13d05;

import java.util.HashSet;
import java.util.Set;

public class Chars {

    public int countChar(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Set<Character> result = new HashSet<>();
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                result.add(c);
            }
        }
        return result.size();
    }
}

// Junior (adatszerkezetes) feladat:
// Írj egy metódust, amely megszámolja, hogy hány különböző betű van egy szóban.
// A kis és nagybetűk közötti különbség nem számít!
// A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az angol ábécé betűit!

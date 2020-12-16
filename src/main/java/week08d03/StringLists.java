package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        List<String> shortWords = new ArrayList<>();
        shortWords.add(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            String item = words.get(i);
            if (item.length() < shortWords.get(0).length()) {
                shortWords.clear();
                shortWords.add(item);
            }
            else if (item.length() == shortWords.get(0).length()) {
                shortWords.add(item);
            }
        }
        return shortWords;
    }

}

// Mai Senior feladat:
// Készíts a week08d03 csomagban egy StringLists osztályt és benne egy shortestWords(List<String> words) metódust,
// mely paraméterül kap egy String listát és a legrövidebb szavakat vissza adja belőle egy Listában.
// PL :{"aaa", "aa", "bb", "cccc", "dd"} Itt a legrövidebb szavak az "aa", "bb", "dd".
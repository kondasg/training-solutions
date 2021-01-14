package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (word.indexOf(c) > -1) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> s = List.of("alma", "Cica", "abc", "Csibe", "uccu");
        System.out.println(new WordFilter().wordsWithChar(s, 'c'));
    }
}

// Mai junior/mid-level feladat:
// Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
// A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter,
// majd ezeket visszaadja egy listában.
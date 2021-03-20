package week05d03;

import java.util.List;

public class ListCounter {

    public int numberOfStartsWith(List<String> words, String starts) {
        if (starts == null || starts.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        if (words == null) {
            return result;
        }
        for (String word : words) {
            if (word.startsWith(starts)) {
                result++;
            }
        }
        return result;
    }
}

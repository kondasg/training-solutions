package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> result = new TreeSet<>();
        for (String s : randomStrings) {
            result.add(s);
        }
        return result;
    }
}

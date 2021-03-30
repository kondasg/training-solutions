package zarovizsga.potpotvizsga.uniquefinder;

import java.util.*;

public class UniqueFinder {

    public List<Character> uniqueChars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s is null");
        }
        Set<Character> result = new LinkedHashSet<>();
        for (Character c : s.toCharArray()) {
            result.add(c);
        }
        return new ArrayList<>(result);
    }
}

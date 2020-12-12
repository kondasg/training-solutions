package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexesOfChar(String s, char c) {
        List<Integer> l = new ArrayList<>();
        for ( int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                l.add(i);
            }
        }
        return l;
    }

}

package week04;

import java.util.ArrayList;
import java.util.List;

public class CharOperations {

    public List<Integer> getPositionOfChar(String base, String part) {
        List<Integer> poz = new ArrayList<>();
        for (int i = 0; i < base.length(); i++) {
            if (part.equals(base.substring(i, i + 1))) {
                poz.add(i);
            }
        }
        return poz;
    }

    public static void main(String[] args) {
        CharOperations c = new CharOperations();
        System.out.println(c.getPositionOfChar("alma", "a"));
    }
}

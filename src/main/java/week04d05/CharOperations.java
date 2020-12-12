package week04d05;

import java.util.ArrayList;
import java.util.List;

public class CharOperations {

    public List<Integer> getPositionOfChar(String base, String part) {
        List<Integer> poz = new ArrayList<>();
        int baseLength = base.length();
        for (int i = 0; i < baseLength; i++) {
            int endPoz = i + 1;
            if (endPoz > baseLength) endPoz = baseLength;
            if (part.equals(base.substring(i, endPoz))) {
                poz.add(i);
            }
        }
        return poz;
    }

    public static void main(String[] args) {
        CharOperations c = new CharOperations();
        System.out.println(c.getPositionOfChar("alma", "aaaaa"));
    }

}

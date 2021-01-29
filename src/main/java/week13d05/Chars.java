package week13d05;

import java.util.HashSet;
import java.util.Set;

public class Chars {

    public int countChar(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Set<String> result  = new HashSet<>();
        for (char c: chars ) {
            if (c >= 'a' && c <= 'z') {
                result.add(c+"");
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(new Chars().countChar("abcdeabcde"));
    }
}

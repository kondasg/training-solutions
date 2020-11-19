package stringbuilder.stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word) {
        if (word == null) throw new IllegalArgumentException("Text must not be null!");
        word = word.trim();
        StringBuilder sb = new StringBuilder(word);
        return word.equalsIgnoreCase(sb.reverse().toString());
    }

}

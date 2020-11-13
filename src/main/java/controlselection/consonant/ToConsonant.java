package controlselection.consonant;

public class ToConsonant {
    public char convertToConsonant(char c) {
        String pattern = "aeiouAEIOU";
        if (pattern.indexOf(c) >= 0) return (char) (c + 1);
        else return c;
    }
}

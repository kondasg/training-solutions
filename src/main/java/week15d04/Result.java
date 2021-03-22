package week15d04;

public class Result {

    private int vowels;
    private int nonVowels;
    private int spaces;
    private int others;

    public int getVowels() {
        return vowels;
    }

    public int getNonVowels() {
        return nonVowels;
    }

    public int getSpaces() {
        return spaces;
    }

    public int getOthers() {
        return others;
    }

    public void incVowels() {
        vowels++;
    }

    public void incNonVowels() {
        nonVowels++;
    }

    public void incSpaces() {
        spaces++;
    }

    public void incOthers() {
        others++;
    }
}

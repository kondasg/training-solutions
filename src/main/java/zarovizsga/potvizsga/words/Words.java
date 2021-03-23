package zarovizsga.potvizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int countDigits = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                countDigits++;
            }
        }
        return s.length() - countDigits < countDigits;
    }

}

package week05d02;

public class ChangeLetter {

    public static final String VOWELS = "aáeéiíoóöőuúüű";
    public static final String REPLACE_CHAR = "*";
    public static final char[] VOWELS_ARRAY = {'a','á','e','é','i','í','o','ó','ö','ő','u','ú','ü','ű'};

    public String changeVowels(String target) {
        String s = "";
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'a' || target.charAt(i) == 'e' ||
                    target.charAt(i) == 'i' || target.charAt(i) == 'o' || target.charAt(i) == 'u') {
                s+= "*";
            }
            else {
                s += target.substring(i,i+1);
            }
        }
        return s;
    }

    public String changeVowels2(String target) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            String c = target.substring(i,i+1).toLowerCase();
            if (VOWELS.contains(c)) {
                sb.append(REPLACE_CHAR);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String changeVowels3(String target) { // lassu, mert végig megy minden esetben a stringen
            for (char c: VOWELS_ARRAY ) {
                target = target.toLowerCase().replace(c, '*');
            }
        return target;
    }
}

package controliteration.pi;

import java.util.ArrayList;
import java.util.List;

public class PiGenerator {
    private final String SZASZ_PAL_PI_POEM = "Nem a régi s durva közelítés, Mi szótól szóig így kijön Betűiket számlálva. Ludolph eredménye már, Ha itt végezzük húsz jegyen. De rendre kijő még tíz pontosan, Azt is bízvást ígérhetem.";

    public String getPi() {
       List<String> words = new ArrayList<>();
       String word = "";
       String pi = "";

       for (int i = 0; i < SZASZ_PAL_PI_POEM.length(); i++) {
            if (" ".equals(SZASZ_PAL_PI_POEM.substring(i, i + 1)) ||
                    ",".equals(SZASZ_PAL_PI_POEM.substring(i, i + 1)) ||
                    ".".equals(SZASZ_PAL_PI_POEM.substring(i, i + 1)) ) {
                if (!word.equals("")) {
                    words.add(word);
                    word = "";
                }
            }  else {
                word = word + SZASZ_PAL_PI_POEM.charAt(i);
            }
        }
       for (int i = 0; i < words.size(); i++) {
           if (i == 1) pi = pi + ".";
           pi = pi + words.get(i).length();
       }
        return pi;
    }

    public static void main(String[] args) {
        new PiGenerator().getPi();
    }
}

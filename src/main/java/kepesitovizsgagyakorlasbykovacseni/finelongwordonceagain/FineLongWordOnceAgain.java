package kepesitovizsgagyakorlasbykovacseni.finelongwordonceagain;

public class FineLongWordOnceAgain {

    public char[][] getFineLongWordOnceAgainButNowInAReverseWay(String word, int width) {
        if (word.length() < width) {
            throw new IllegalArgumentException("Number of letters cannot be more than length of the word!");
        }
        int x = word.length() - width + 1;
        char[][] res = new char[x][width];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < width; j++) {
                int poz = i + j;
                res[i][j] = word.toUpperCase().charAt(poz);
            }
        }
        return res;
    }
}

// https://github.com/kovacseni/kepesitovizsga-gyakorlas-v7.0
// Szép hosszú szavak

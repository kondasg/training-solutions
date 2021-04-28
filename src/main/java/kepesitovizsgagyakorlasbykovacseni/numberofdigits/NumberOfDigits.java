package kepesitovizsgagyakorlasbykovacseni.numberofdigits;

public class NumberOfDigits {
    public int getNumberOfDigits(int numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numbers; i++) {
            sb.append(i);
        }
        return sb.length();
    }
}

// https://github.com/kovacseni/kepesitovizsga-gyakorlas
// Számjegyek
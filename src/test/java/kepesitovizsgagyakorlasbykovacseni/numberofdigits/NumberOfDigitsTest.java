package kepesitovizsgagyakorlasbykovacseni.numberofdigits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfDigitsTest {

    @Test
    public void testGetNumberOfDigits() {
        Assertions.assertEquals(13, new NumberOfDigits().getNumberOfDigits(11));
    }

    @Test
    public void testGetNumberOfDigits2() {
        Assertions.assertEquals(3, new NumberOfDigits().getNumberOfDigits(3));
    }

    @Test
    public void testGetNumberOfDigits3() {
        Assertions.assertEquals(29, new NumberOfDigits().getNumberOfDigits(19));
    }
}

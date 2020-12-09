package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

    @Test
    void sumTest() {
        assertEquals(18, new DigitSum().sumOfDigits(648));
    }
}

package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {
    @Test
    void Test() {
        assertEquals("*lm*", new ChangeLetter().changeVowels("alma"));
        assertEquals("*lm* ****", new ChangeLetter().changeVowels("alma eiou"));
    }
}

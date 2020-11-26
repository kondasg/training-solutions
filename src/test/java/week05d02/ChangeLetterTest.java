package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {
    @Test
    void Test() {
        assertEquals("*lm*", new ChangeLetter().changeVowels("alma"));
        assertEquals("*lm* ****", new ChangeLetter().changeVowels("alma eiou"));
    }

    @Test
    void Test2() {
        assertEquals("*lm*", new ChangeLetter().changeVowels2("alma"));
        assertEquals("*lm* ****", new ChangeLetter().changeVowels2("alma eiou"));
    }

    @Test
    void Test3() {
        assertEquals("*lm*", new ChangeLetter().changeVowels3("alma"));
        assertEquals("*lm* ****", new ChangeLetter().changeVowels3("alma eiou"));
    }
}

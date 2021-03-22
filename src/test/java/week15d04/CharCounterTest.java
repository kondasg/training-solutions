package week15d04;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void counter() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CharCounter.class.getResourceAsStream("data.txt")))) {
            Result result = new CharCounter().counter(reader);
            assertEquals(17, result.getVowels());
            assertEquals(27, result.getNonVowels());
            assertEquals(21, result.getOthers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
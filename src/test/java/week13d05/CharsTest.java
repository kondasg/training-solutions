package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharsTest {

    Chars chars = new Chars();

    @Test
    void countChar() {
        assertEquals(6, chars.countChar("ancDEacTe"));
        assertEquals(0, chars.countChar(""));
        assertEquals(0, chars.countChar("   "));
        assertEquals(3, chars.countChar("  f  g h _ % 6 4 f F"));
    }
}
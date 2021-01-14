package week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void wordsWithChar() {
        List<String> s = List.of("alma", "Cica", "abc", "Csibe", "uccu");
        assertEquals(3, new WordFilter().wordsWithChar(s, 'c').size());
    }
}
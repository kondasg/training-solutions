package week04d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void getIndexesOfChar() {
        assertEquals(List.of(0,3,5), new Search().getIndexesOfChar("almafa ", 'a'));
    }
}
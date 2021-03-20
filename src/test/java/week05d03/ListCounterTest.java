package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    ListCounter listCounter = new ListCounter();
    List<String> words = List.of("Alma", "körte", "ananász", "Kiwi", "meggy", "szeder", "kesudió");

    @Test
    void numberOfStartsWith() {
        assertEquals(0, listCounter.numberOfStartsWith(new ArrayList<>(), "a"));
        assertEquals(0, listCounter.numberOfStartsWith(words, "x"));
        assertEquals(1, listCounter.numberOfStartsWith(words, "A"));
        assertEquals(2, listCounter.numberOfStartsWith(words, "k"));
    }
}
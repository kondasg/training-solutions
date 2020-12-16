package week08d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void listTest() {
        StringLists stringLists = new StringLists();

        List<String> inpuut = List.of("aaa", "aa", "bb", "cccc", "dd");

        assertEquals(List.of("aa", "bb", "dd"), stringLists.shortestWords(inpuut));
    }

}
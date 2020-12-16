package week08d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsJuniorMidTest {

    @Test
    void unionTest() {
        StringListsJuniorMid stringListsJuniorMid = new StringListsJuniorMid();

        List<String> first = new ArrayList<>(List.of("a", "b", "c", "d"));
        List<String> second = new ArrayList<>(List.of("a", "f", "c", "e"));

        assertEquals(List.of("a", "b", "c", "d", "f", "e"), stringListsJuniorMid.stringListsUnion(first, second));
    }

}
package week06d01;

import org.junit.jupiter.api.Test;
import week05d03.User;
import week05d03.UserValidator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    void Test1() {
        ListSelector listSelector = new ListSelector();

        assertEquals("[almabanánmandarin]", listSelector.select(List.of("alma","korte","banán","narancs","mandarin","kiwi")));
    }

    @Test
    void Test2() {
        ListSelector listSelector = new ListSelector();

        assertEquals("", listSelector.select(List.of()));
    }

    @Test
    void Test3() {
        ListSelector listSelector = new ListSelector();

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> listSelector.select(null) );
        assertEquals("List is null!", iae.getMessage());
    }
}

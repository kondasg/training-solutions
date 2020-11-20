package week04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharOperationsTest {
    @Test
    void Test() {
        CharOperations c = new CharOperations();
        List<Integer> x = c.getPositionOfChar("alma", "a");
        assertEquals(2, x.size());
    }
    @Test
    void Test2() {
        CharOperations c = new CharOperations();
        List<Integer> x = c.getPositionOfChar("alma", "aaaaa");
        assertEquals(0, x.size());
    }

}

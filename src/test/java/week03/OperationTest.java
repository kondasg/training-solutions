package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    void testOperation() {
        Operation operation = new Operation("  10 + 11  ");

        assertEquals(21, operation.getResult());
    }
}

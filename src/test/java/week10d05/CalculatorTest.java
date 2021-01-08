package week10d05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void findMinSumTest() {
        int[] arr = {4, 7, 1, 11, 5, 9, 3};
        new Calculator().findMinSum(arr);

        assertEquals("13", outputStreamCaptor.toString().trim());
    }

    @Test
    void findMinMaxSumTest() {
        int[] arr = {4, 7, 1, 11, 5, 9, 3, 25, 22, 33};
        new Calculator().findMinMaxSum(arr);

        assertEquals("13, 91", outputStreamCaptor.toString().trim());
    }

}
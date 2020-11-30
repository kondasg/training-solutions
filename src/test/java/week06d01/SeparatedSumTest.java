package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparatedSumTest {

    @Test
    void Test() {
        SeparatedSum separatedSum = new SeparatedSum();
        ReturnSum returnSum = separatedSum.sum("1,1;-24,94;6,91;-11,11;5,7;-9,4");
        assertEquals(13.71, returnSum.getPositive(), 0.0005);
        assertEquals(-45.45, returnSum.getNegative(), 0.0005);
    }

}

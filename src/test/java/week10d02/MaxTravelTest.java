package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        List<Integer> l = List.of(12,12,0,3,4,4,12);
        MaxTravel maxTravel = new MaxTravel();
        assertEquals(12, maxTravel.getMaxIndex(l));
    }
}
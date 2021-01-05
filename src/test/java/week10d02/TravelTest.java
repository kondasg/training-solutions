package week10d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMax() {

        Travel travel = new Travel();

        assertEquals(12, travel.getStopWithMax("utasdata.txt"));
    }
}
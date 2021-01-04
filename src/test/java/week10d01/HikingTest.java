package week10d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevation() {
        Hiking hiking = new Hiking();

        List<Double> elevations = List.of(10d,20d,15d,18d);

        assertEquals(13.0, hiking.getPlusElevation(elevations) );

    }
}
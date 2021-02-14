package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    void functionMaximum() {

        Coordinates coordinates = new Coordinates();

        Map<Double, Double> c = new HashMap<>();
        c.put(-2.0, -1.0);
        c.put(-1.0, -7.0);
        c.put(0.0, 1.0);
        c.put(2.0, 0.0);
        c.put(1.0, -0.5);
        Map.Entry<Double, Double> result = coordinates.functionMaximum(c);

        assertEquals(0.0, result.getKey());
        assertEquals(1.0, result.getValue());
    }
}
package week06d05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    void addBottle() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        assertEquals(0, bottle.getFilledUntil());
    }

    @Test
    void fillBottle() {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        bottle.fill(110);
        assertEquals(110, bottle.getFilledUntil());
    }

    @Test
    void overflow() throws IllegalArgumentException {
        Bottle bottle = Bottle.of(BottleType.GLASS_BOTTLE);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> bottle.fill(500));
        assertEquals("Nem fér bele!", ex.getMessage());
    }
}

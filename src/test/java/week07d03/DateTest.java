package week07d03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {

    @DisplayName("Ide értelmes szövget írt ki")
    @Test
    void ofTest() {
        Date target = Date.of(2020,12,31);
        Date result = target.withDay(24);
        assertEquals( Date.of(2020,12,24), result);
    }

}

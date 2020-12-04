package week06d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeriesTest {

    @Test
    void upTest() {
        Series series = new Series();
        assertEquals("növekvő", series.calculateSeriesType(List.of(1,2,3,4,9,10)));
    }

    @Test
    void downTest() {
        Series series = new Series();
        assertEquals("csökkenő", series.calculateSeriesType(List.of(1,0,-1,-2)));
    }

    @Test
    void upDownTest() {
        Series series = new Series();
        assertEquals("vegyes", series.calculateSeriesType(List.of(1,0,1,2,5,3)));

    }
}

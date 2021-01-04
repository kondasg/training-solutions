package week10d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void Test() {
        HikingFile hikingFile = new HikingFile();

        Elevation ev = hikingFile.getElevation("gps.txt");

        assertEquals(40.0, ev.getPlus());
        assertEquals(30.0, ev.getMinus());
    }
}
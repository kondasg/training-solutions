package week20d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperSoftwareTest {

    @Test
    void increasePrice() {
        DeveloperSoftware ds = new DeveloperSoftware("Jack", 1000);
        ds.increasePrice();
        assertEquals(1100, ds.getPrice());
    }
}
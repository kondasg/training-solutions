package week20d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        OfficeSoftware os = new OfficeSoftware("Jack", 1000);
        os.increasePrice();
        assertEquals(1050, os.getPrice());
    }



}
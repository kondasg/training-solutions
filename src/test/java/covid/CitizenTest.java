package covid;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void createCitizen() {
        Citizen citizen = new Citizen("Józsi", "1234", LocalDate.of(2000, 5, 15), "email@email.hu", "1234567890");

        assertEquals("email@email.hu", citizen.getEmail());
        assertEquals("1234567890", citizen.getTaj());
    }

}
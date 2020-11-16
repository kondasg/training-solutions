package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test
    void createNameChangerTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()->  new NameChanger(""));
        assertEquals("Invalid Name:", iae.getMessage());
    }

    @Test
    void changeFirstNameTest() {
        NameChanger nameChanger = new NameChanger("Kiss Józsi");
        nameChanger.changeFirstName("Béla");
        assertEquals("Kiss Béla", nameChanger.getFullName() );
    }
}

package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTest {

    @Test
    void changeFirstName() {
        NameChanger nameChanger = new NameChanger("Kiss Józsi");
        nameChanger.changeFirstName("Béla");
        assertEquals("Kiss Béla", nameChanger.getFullName() );
    }
}

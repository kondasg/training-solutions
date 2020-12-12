package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

    @Test
    void createNameChangerTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid Name:", iae.getMessage());
    }

    @Test
    void changeFirstNameTest() {
        NameChanger nameChanger = new NameChanger("Kiss Józsi");
        nameChanger.changeFirstName("Béla");
        assertEquals("Kiss Béla", nameChanger.getFullName() );
    }

    @Test
    void isTheSameTest(){
        NameChanger nameChanger = new NameChanger("Kiss Józsi");
        // assertEquals(true, nameChanger.isTheSame("Kiss Józsi"));
        assertTrue( nameChanger.isTheSame("Kiss Józsi"));
        assertFalse(nameChanger.isTheSame("Józsi Kiss"));
    }
}

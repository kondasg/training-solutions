package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    @Test
    void Test() {
        UserValidator userValidator = new UserValidator();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("", 55), new User("Jack Doe", 11))) );
        assertEquals("Üres String!", iae.getMessage());
    }

    @Test
    void Test2() {
        UserValidator userValidator = new UserValidator();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("Jill", 121))) );
        assertEquals("nem megfelő age!", iae.getMessage());

        IllegalArgumentException iae2 = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("Jill", -1))) );
        assertEquals("nem megfelő age!", iae2.getMessage());
    }
}

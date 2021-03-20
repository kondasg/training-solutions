package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorTest {

    @Test
    void Test() {
        UserValidator userValidator = new UserValidator();
        assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("", 55), new User("Jack Doe", 11))) );
    }

    @Test
    void Test2() {
        UserValidator userValidator = new UserValidator();
        assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("Jill", 121))) );

        assertThrows(IllegalArgumentException.class, () -> userValidator.validate(Arrays.asList(new User("John Doe", 50), new User("Jill", -1))) );
    }
}

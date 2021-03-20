package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User("first", "last", "first@last.hu");

    @Test
    void createUser() {
        assertEquals("first", user.getFirstName());
        assertEquals("last", user.getLastName());
        assertEquals("first@last.hu", user.getEmail());
    }

    @Test
    void createUserFail() {
        assertThrows(IllegalArgumentException.class, () -> new User("first", "last", "first"));
    }

    @Test
    void getFullName() {
        assertEquals("first last", user.getFullName());
    }
}
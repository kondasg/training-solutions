package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTestJ5 {

    @Test
    void testSayHello() {
        Gentleman gentleman = new Gentleman();
        assertEquals(gentleman.sayHello("John Doe"), "Hello John Doe");
    }
    @Test
    void testSayHello2() {
        Gentleman gentleman = new Gentleman();
        assertEquals(gentleman.sayHello(null), "Hello Anonymous");
    }

}

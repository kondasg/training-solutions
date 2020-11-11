package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {
    @Test
    public void testSayHello() {
        Gentleman gentleman = new Gentleman();
        assertThat(gentleman.sayHello("John Doe"), equalTo("Hello John Doe"));
    }
    @Test
    public void testSayHello2() {
        Gentleman gentleman = new Gentleman();
        assertThat(gentleman.sayHello(null), equalTo("Hello Anonymous"));
    }

}

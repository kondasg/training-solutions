package week12d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {

    public List<Client> clients = new ArrayList<>();

    @BeforeEach
    void init() {
        clients.add(new Client("John Doe", "abc12"));
        clients.add(new Client("Jane Doe", "a12a"));
        clients.add(new Client("Jack Doe", "x22"));
        clients.add(new Client("John Lenon", "abc123"));
        clients.add(new Client("Jack Lemon", "j1"));
    }

    @Test
    void findByRegNumber() {
        Clients c = new Clients(clients);
        assertEquals("Jack Doe", c.findByRegNumber("x22"));
    }

    @Test
    void findByName() {
        Clients c = new Clients(clients);
        List<Client> result = c.findByName("Doe");
        assertEquals(3, result.size());
        assertEquals("John Doe", result.get(0).getName());

        List<Client> result2 = c.findByName("Jack");
        assertEquals(2, result2.size());
    }
}
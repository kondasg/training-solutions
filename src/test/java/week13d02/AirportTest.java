package week13d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    Airport airport = new Airport();

    @BeforeEach
    void init() {
        airport.readFile(Airport.class.getResourceAsStream("/cities.txt"));
    }

    @Test
    void readFile() {
        assertEquals(100, airport.getFlights().size());
    }

    @Test
    void arrivalOrDeparture() {
        assertEquals("Departure", airport.arrivalOrDeparture());
    }

    @Test
    void findFlight() {
        assertEquals("Budapest", airport.findFlight("JM2181").getCity());
        assertEquals(LocalTime.of(15,49,0,0), airport.findFlight("BB1990").getTime());
    }

    @Test
    void flightCities() {
        assertEquals(5, airport.flightCities("Vaduz", "Departure").size());
        assertEquals(3, airport.flightCities("Bucharest", "Arrival").size());
    }

    @Test
    void earliestFlight() {
        assertEquals("JE9763", airport.earliestFlight().getFlightNumber());
    }
}
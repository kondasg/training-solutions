package week11d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void addRide() {
        Courier courier = new Courier();

        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(1, 2, 1));
        courier.addRide(new Ride(3, 1, 1));

        assertEquals(3, courier.getRides().size());
    }


    @Test
    void addRideError() {
        Courier courier = new Courier();

        courier.addRide(new Ride(1, 2, 1));
        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(3, 1, 1));

        assertEquals(1, courier.getRides().size());
    }

    @Test
    void freeDay() {
    }
}
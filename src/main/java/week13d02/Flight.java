package week13d02;

import java.time.LocalTime;

public class Flight {

    private final String flightNumber;
    private final String arrivalDeparture;
    private final String city;
    private final LocalTime time;

    public Flight(String flightNumber, String arrivalDeparture, String city, LocalTime time) {
        this.flightNumber = flightNumber;
        this.arrivalDeparture = arrivalDeparture;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getArrivalDeparture() {
        return arrivalDeparture;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }
}

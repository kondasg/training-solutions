package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void readFile(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                String[] splittedTime = splittedLine[3].split(":");
                flights.add(new Flight(splittedLine[0], splittedLine[1], splittedLine[2],
                        LocalTime.of(Integer.parseInt(splittedTime[0]), Integer.parseInt(splittedTime[1]), 0, 0)));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public String arrivalOrDeparture() {
        int arrival = 0;
        int departure = 0;
        for (Flight flight : flights) {
            if ("Arrival".equals(flight.getArrivalDeparture())) {
                arrival++;
            }
            if ("Departure".equals(flight.getArrivalDeparture())) {
                departure++;
            }
        }
        return (arrival > departure) ? "Arrival" : "Departure";
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flightNumber.equals(flight.getFlightNumber())) {
                return flight;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen járat");
    }

    public List<Flight> flightCities(String city, String arrivalDeparture) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (city.equals(flight.getCity()) && arrivalDeparture.equals(flight.getArrivalDeparture())) {
                result.add(flight);
            }
        }
        return result;
    }

    public Flight earliestFlight() {
        LocalTime earliestTime = flights.get(0).getTime();
        Flight earliestFlight = flights.get(0);
        for (Flight flight : flights) {
            if (earliestTime.isAfter(flight.getTime())) {
                earliestTime = flight.getTime();
                earliestFlight = flight;
            }
        }
        return earliestFlight;
    }
}

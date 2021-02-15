package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger) {
        if (getBoat().getMaxPassengers() > passengers.size()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("nincs hely");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return getBasicPrice() * passenger.getCruiseClass().getMultiplier();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (name.equals(passenger.getName())) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("nincs ilyen passenger");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();
        for (Passenger passenger : passengers) {
            result.add(passenger.getName());
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger : passengers) {
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger passenger : passengers) {
            CruiseClass cc = passenger.getCruiseClass();
            if (result.containsKey(cc)) {
                result.put(cc, result.get(cc) + 1);
            } else {
                result.put(cc, 1);
            }
        }
        return result;
    }
}

package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        if (ride == null) {
            throw new IllegalArgumentException("Ride is null");
        }
        if (rides.size() == 0) {
            rides.add(ride);
        } else {
            if (rides.get(rides.size() - 1).getDay() <= ride.getDay()) {
                if (rides.get(rides.size() - 1).getDay() == ride.getDay() && rides.get(rides.size() - 1).getCounter() < ride.getCounter()) {
                    rides.add(ride);
                } else {
                    throw new IllegalArgumentException("The counter must be bigger");
                }
            } else {
                throw new IllegalArgumentException("The day must be bigger");
            }
        }

    }

    public int freeDay() {
        int result = -1;

        for (int i = 1; i < rides.get(rides.size()-1).getDay(); i++) {
            for (Ride item : rides) {
                if (i != item.getDay()) {
                    return i;
                }
            }
        }
        return result;
    }
}

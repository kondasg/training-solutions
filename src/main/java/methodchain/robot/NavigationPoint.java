package methodchain.robot;

import java.util.List;

public class NavigationPoint {

    private final int distance;
    private final int azimut;

    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    @Override
    public String toString() {
        return "distance: " + distance + " azimut: " + azimut;
    }
}

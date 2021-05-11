package activitytracker;

import java.time.LocalDateTime;

public class TrackPoint {

    private int id;
    private final LocalDateTime time;
    private final double lat;
    private final double lon;

    public TrackPoint(int id, LocalDateTime time, double lat, double lon) {
        this(time, lat, lon);
        this.id = id;
    }

    public TrackPoint(LocalDateTime time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}

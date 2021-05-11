package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {

    private int id;
    private final LocalDateTime startTime;
    private final String desc;
    private final ActivityType type;
    private final List<TrackPoint> trackPoints;

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackPoints) {
        this(startTime, desc, type, trackPoints);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type, List<TrackPoint> trackPoints) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
        this.trackPoints = trackPoints;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}

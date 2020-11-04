package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private final LocalDate date;
    private final String artist;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Performance(LocalDate date, String artist, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.artist = artist;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getInfo() {
        return artist + ": " + date + " " + startTime + " - " + endTime;
    }
}

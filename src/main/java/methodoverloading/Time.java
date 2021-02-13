package methodoverloading;

public class Time {

    private final int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        return secs() == time.secs();
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return secs() == new Time(hours, minutes, seconds).secs();
    }

    public boolean isEarlier(Time time) {
        return secs() < time.secs();
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return secs() < new Time(hours, minutes, seconds).secs();
    }

    public int secs() {
        return seconds + 60 * minutes + 60 * 60 * hours;
    }
}

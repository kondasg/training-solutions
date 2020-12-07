package constructoroverloading.bus;

public class SimpleTime {

    private final int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
    }

    public SimpleTime(SimpleTime time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        return (60 * hours + minutes) - (60 * time.hours + time.minutes);
    }

    public String toString() {
        return hours + ":" + minutes;
    }
}

package statements;

public class Time {
    private final int hour;
    private final int min;
    private final int sec;

    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getInMinutes() {
        return hour*60+min;
    }

    public int getInSeconds() {
        return hour*60*60+min*60+sec;
    }

    public boolean earlierThan(Time to) {
        return ( this.getInSeconds() < to.getInSeconds() );
    }

    public String toString() {
        return this.hour+":"+this.min+":"+this.sec;
    }
}

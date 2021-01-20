package exceptionclass.course;

public class SimpleTime {

    private final int hour;
    private final int minute;

    public SimpleTime(int hour, int minute) {
        testHourMin(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    private void testHourMin(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }
        if (time.length() != 5 || time.charAt(2) != ':') {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        try {
            String[] hourMin = time.split(":");
            int parseHour = Integer.parseInt(hourMin[0]);
            int parseMinute = Integer.parseInt(hourMin[1]);
            testHourMin(parseHour, parseMinute);
            this.hour = parseHour;
            this.minute = parseMinute;
        }
        catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}

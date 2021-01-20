package ioreadwritebytes.temperatures;

public class Temperatures {

    private final byte[] data;
    private final static int LAST_DAYS = 30;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double sum = 0;
        for (byte item: data) {
            sum += item;
        }
        return sum / data.length;
    }

    public double getMonthAverage() {
        double sum = 0;
        int lastIndex = data.length - 1;
        for (int i = lastIndex; i > lastIndex - LAST_DAYS ; i--) {
            sum += data[i];
        }
        return sum / LAST_DAYS;
    }
}

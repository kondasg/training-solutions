package week15d02;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {

    private final LocalDate date;
    private final LocalTime time;
    private final String courier;
    private final String zip;
    private final String address;

    public Order(LocalDate date, LocalTime time, String courier, String zip, String address) {
        this.date = date;
        this.time = time;
        this.courier = courier;
        this.zip = zip;
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCourier() {
        return courier;
    }

    public String getZip() {
        return zip;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "date=" + date +
                ", time=" + time +
                ", courier='" + courier + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package zarovizsga.potvizsga.cleaning;

public class Office implements Cleanable {

    private final String address;
    private final int area;
    private final int numberOfLevels;

    public Office(String address, int area, int numberOfLevels) {
        this.address = address;
        this.area = area;
        this.numberOfLevels = numberOfLevels;
    }

    @Override
    public int clean() {
        return 100 * area * numberOfLevels;
    }

    @Override
    public String getAddress() {
        return address;
    }
}

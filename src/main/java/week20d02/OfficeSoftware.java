package week20d02;

public class OfficeSoftware extends Software {

    public OfficeSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price *= 1.05;
    }
}

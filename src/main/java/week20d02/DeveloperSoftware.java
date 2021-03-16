package week20d02;

public class DeveloperSoftware extends Software {

    public DeveloperSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    void increasePrice() {
        price *= 1.1;
    }
}

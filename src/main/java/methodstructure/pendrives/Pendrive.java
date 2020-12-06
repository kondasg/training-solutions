package methodstructure.pendrives;

public class Pendrive {

    private final String name;
    private final int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        this.price += (int) (this.price * (percent / 100.0));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double pricePerCapacity = (double) pendrive.getPrice() / pendrive.getCapacity();
        double pricePerCapacityThis = (double) this.getPrice() / this.getCapacity();
        if (pricePerCapacity < pricePerCapacityThis) {
            return 1;
        } else if (pricePerCapacity > pricePerCapacityThis) {
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return pendrive.getPrice() > this.getPrice();
    }

    public String toString() {
        return name + ": " + capacity + " Gb, " + price + "Ft";
    }
}

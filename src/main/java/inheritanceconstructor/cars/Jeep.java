package inheritanceconstructor.cars;

public class Jeep extends Car {

    private final double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        if (extraFuel > extraCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel > extraFuel) {
            double diff = extraFuel - fuel;
            extraFuel = 0;
            setFuel(getFuel() - Math.abs(diff));
        }
        else {
            extraFuel -= fuel;
        }
    }

    public void drive(int km) {
        double fuel = (getFuelRate() / 100) * km;
        if (fuel > getFuel() + extraFuel) {
            throw new RuntimeException("Not enough fuel available!");
        }
        else {
            modifyFuelAmount(fuel);
        }
    } // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!

    public double calculateRefillAmount() {
        return (getTankCapacity() - getFuel()) + (extraCapacity - extraFuel);
    } //kiszámolja, mennyit lehet tankolni
}

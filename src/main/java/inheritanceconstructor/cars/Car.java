package inheritanceconstructor.cars;

public class Car {

    private final double fuelRate;
    private double fuel;
    private final double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel -= fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void drive(int km) {
        double fuel = (fuelRate / 100) * km;
        if (fuel > this.fuel) {
            throw new RuntimeException("Not enough fuel available!");
        }
        else {
            modifyFuelAmount(fuel);
        }
    } // csökkenti az üzemanyag mennyiségét, nem fogyhat ki!

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    } //kiszámolja, mennyit lehet tankolni
}

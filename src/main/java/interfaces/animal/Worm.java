package interfaces.animal;

public class Worm implements Animal {

    int numberOfLegs = 0;
    String name = "Worm";

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }
}

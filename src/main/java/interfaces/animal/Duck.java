package interfaces.animal;

public class Duck implements Animal {

    int numberOfLegs = 2;
    String name = "Duck";

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }
}

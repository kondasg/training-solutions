package interfaces.animal;

public class Lion implements Animal {

    int numberOfLegs = 4;
    String name = "Lion";

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }
}

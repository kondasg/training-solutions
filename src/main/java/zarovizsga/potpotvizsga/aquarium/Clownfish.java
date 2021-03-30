package zarovizsga.potpotvizsga.aquarium;

public class Clownfish extends Fish {

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color, false);
    }

    @Override
    protected void feed() {
        weight += 1;
    }
}

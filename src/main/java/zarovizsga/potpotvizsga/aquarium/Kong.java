package zarovizsga.potpotvizsga.aquarium;

public class Kong extends Fish {

    public Kong(String name, int weight, String color) {
        super(name, weight, color, false);
    }

    @Override
    protected void feed() {
        weight += 2;
    }
}

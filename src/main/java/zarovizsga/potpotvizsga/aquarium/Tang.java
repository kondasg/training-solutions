package zarovizsga.potpotvizsga.aquarium;

public class Tang extends Fish {

    public Tang(String name, int weight, String color) {
        super(name, weight, color, true);
    }

    @Override
    protected void feed() {
        weight += 1;
        memoryLoss = true;
    }


}

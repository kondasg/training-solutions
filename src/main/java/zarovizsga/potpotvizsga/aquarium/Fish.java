package zarovizsga.potpotvizsga.aquarium;

public abstract class Fish {

    protected String name;
    protected int weight;
    protected String color;
    protected boolean memoryLoss;

    public Fish(String name, int weight, String color, boolean memoryLoss) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.memoryLoss = memoryLoss;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color + ", short term memory loss: " + memoryLoss;
    }

    protected abstract void feed();

}

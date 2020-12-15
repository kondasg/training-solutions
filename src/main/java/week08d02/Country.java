package week08d02;

public class Country {

    private final String name;
    private final int population;
    private final int numberOfFlagColors;
    private final int neighbors;

    public Country(String name, int population, int numberOfFlagColors, int neighbors) {
        this.name = name;
        this.population = population;
        this.numberOfFlagColors = numberOfFlagColors;
        this.neighbors = neighbors;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumberOfFlagColors() {
        return numberOfFlagColors;
    }

    public int getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", numberOfFlagColors=" + numberOfFlagColors +
                ", neighbors=" + neighbors +
                '}';
    }
}

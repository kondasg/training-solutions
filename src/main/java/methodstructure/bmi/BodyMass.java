package methodstructure.bmi;

public class BodyMass {

    private final double weight;
    private final double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return weight / (height * height);
    }

    public BmiCategory body() {
        if (bodyMassIndex() < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        }
        else if (bodyMassIndex() > 25) {
            return BmiCategory.OVERWEIGHT;
        }
        else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return this.bodyMassIndex() < bodyMass.bodyMassIndex();
    }
}

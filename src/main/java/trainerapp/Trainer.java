package trainerapp;

public class Trainer {
    private String name;
    private int yearOfBirth;

    public Trainer() {
        name = "JD";
        yearOfBirth = 2000;
    }

    public String getName() {
        return name;
    }

    public String getNameAndYearOfBirth() {
        return name + ": " + yearOfBirth;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}

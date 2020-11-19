package stringbasic.pets;

import java.time.LocalDate;

public class Pet {
    private final String name;
    private final LocalDate birth;
    private final Gender gender;
    private final String regNumber;

    public Pet(String name, LocalDate birth, Gender gender, String regNumber) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegNumber() {
        return regNumber;
    }
}

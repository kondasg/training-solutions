package week12d05;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private final int age;
    private final int skillLevel;
    private final String name;
    private final List<String> skills;

    public Employee(int age, int skillLevel, String name, List<String> skills) {
        this.age = age;
        this.skillLevel = skillLevel;
        this.name = name;
        this.skills = skills;
    }

    public int getAge() {
        return age;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }
}

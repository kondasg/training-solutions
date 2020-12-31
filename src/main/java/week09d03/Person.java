package week09d03;

import java.util.Random;

public class Person {

    private final String name;
    private final int age;
    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent() {
        Present present;
        do {
            present =  randomPresent();
        } while (age > 14 && present == Present.TOY);
        this.present = present;
    }

    public Present randomPresent() {
        Present[] presents = Present.values();
        Random random = new Random();
        int num = random.nextInt(Present.values().length);
        return presents[num];
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", present=" + present +
                '}';
    }
}

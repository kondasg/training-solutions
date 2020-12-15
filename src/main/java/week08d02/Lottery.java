package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    private static final int NUMBER_OF_DRAWS = 5;

    public int random() {
        return new Random().nextInt(90) + 1;
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int num;
        for (int i = 0; i < NUMBER_OF_DRAWS; i++ ) {
            do {
                num = random();
            }
            while (numbers.contains(num));
            numbers.add(num);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.getNumbers());
    }

}

// Készíts a week08d02 csomagban egy Lottery osztályt,
// melynek legyen egy getNumbers() metódusa,
// ami visszaad egy listát amiben 5 véletlen szám van 1-90 között,
// tehát kvázi készíts egy lottósorsoló programot.
// A sorrendre nem kell figyelni, a lényeg, hogy a számok különbözők legyenek!
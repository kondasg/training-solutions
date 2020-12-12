package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private final String name;
    private final int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return name + ": " + bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public static void main(String[] args) {
        List<Position> p = new ArrayList<>();
        p.add(new Position("A", 100_000));
        p.add(new Position("C", 600_000));
        p.add(new Position("H", 200_000));

        for (Position item: p) {
            if (item.getBonus() > 150_000) System.out.println(item);
        }

    }
}

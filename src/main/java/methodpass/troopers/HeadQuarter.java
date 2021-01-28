package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private final List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        troopers.add(trooper);
    }

    public void moveClosestTrooper(Position target) {
        moveTrooper(findClosestTrooper(target), target);
    }

    public void moveTrooperByName(String name, Position target) {
        findTrooperByName(name).changePosition(target);
    }

    public Trooper findTrooperByName(String name) {
        for (Trooper trooper: troopers) {
            if (name.equals(trooper.getName())) {
                return trooper;
            }
        }
        return null;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper closest = troopers.get(0);
        for (Trooper trooper : troopers) {
            if (trooper.distanceFrom(target) < closest.distanceFrom(target)) {
                closest = trooper;
            }
        }
        return closest;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }


}

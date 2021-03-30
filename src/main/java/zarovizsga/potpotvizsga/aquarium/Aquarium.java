package zarovizsga.potpotvizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aquarium {

    private final List<Fish> status = new ArrayList<>();

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish fish : status) {
            result.add(fish.status());
        }
        return result;
    }

    public void addFish(Fish fish) {
        status.add(fish);
    }

    public void removeFish() {
        Iterator<Fish> it = status.iterator();
        while (it.hasNext()) {
            Fish fish = it.next();
            if (fish.getWeight() >= 11) {
                it.remove();
            }
        }
    }

    public void feed() {
        for (Fish fish : status) {
            fish.feed();
        }
    }
}

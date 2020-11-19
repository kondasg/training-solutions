package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private final List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        for (Pet item: pets) {
            if (areEquals(item, pet)) return;
        }
        pets.add(pet);
    }

    private boolean areEquals(Pet pet1, Pet pet2) {
        return pet1.getRegNumber().equals(pet2.getRegNumber());
    }


}

package week11d04;

import java.util.ArrayList;
import java.util.List;

public class NameLength {

    public List<Integer> getLengths(List<String> names) {
        List<Integer> lengthOfNames = new ArrayList<>();
        for (String name: names) {
            if (name.startsWith("J")) {
                int length = name.length();
                if (!lengthOfNames.contains(length)) {
                    lengthOfNames.add(length);
                }
            }
        }
        return lengthOfNames;
    }

    public static void main(String[] args) {
        List<String> s = List.of("Joe", "Jack", "Jane", "Jake", "George", "William");
        System.out.println(new NameLength().getLengths(s));
    }
}

// Mai senior feladat:
// Adott egy nevek listája. Add vissza egy listában, hogy milyen hosszúságú J karakterrel kezdődő nevek szerepelnek a listában!
// Minden szám csak egyszer szerepeljen! A NameLength osztály getLengths(List<String>) metódusába dolgozz!
// Ha a bemenet pl. List.of("Joe", "Jack", "Jane", "Jake", "George", "William"), a visszatérési érték [3, 4] legyen!
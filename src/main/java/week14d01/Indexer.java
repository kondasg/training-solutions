package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String name : names) {
            List<String> nameList = new ArrayList<>();
            char firstChar = name.charAt(0);
            if (result.containsKey(firstChar)) {
                nameList = result.get(firstChar);
            }
            nameList.add(name);
            result.put(firstChar, nameList);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Aaron", "Lukas")));
    }
}

// Mai junior/medior feladat:
// Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
// A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes névvel,
// mely ezzel a betűvel kezdődik).
// Példa:
// System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}
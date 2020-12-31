package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> persons = new ArrayList<>();

    public SantaClaus(List<Person> persons) {
        this.persons = persons;
    }

    public void getThroughChimneys() {
        for (Person person: persons) {
            person.setPresent();
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", 5));
        persons.add(new Person("b", 15));
        persons.add(new Person("c", 25));
        persons.add(new Person("d", 8));
        SantaClaus santaClaus = new SantaClaus(persons);
        santaClaus.getThroughChimneys();
        System.out.println(persons);
    }
}

// A  mai feladatban Mikulásnak segítünk ajándékokat kiosztani.
// A week09d03 csomagba  dolgozz.
// Készíts egy Present nevű enumot a következő felsorolókkal: Toy, Electronic, Housekepping, Decoration.
// Ezek fogják az ajándékok típusát reprezentálni.
// Készíts egy Person osztályt legyen neki neve és életkora és legyen egy Present típusú attribútuma.
// A nevet és életkort konstruktorban kapja meg. Legyen egy setPresent() metódusa ami beállítja az ajándék attribútumot véletlenszerűen,
// egy kitétel van, 14 év fölötti nem kaphat játékot.
// Ennek megvalósításához szabadon bővíthetőek az eddig elkészült elemek.
// Legyen egy SantaClaus osztály, akinek van egy Person listája, amit konstruktorban kap meg.
// Legyen neki egy getThroughChimneys() metódusa, ami végigmegy az emberek listáján és meghívja minden ember setPresent() metódusát
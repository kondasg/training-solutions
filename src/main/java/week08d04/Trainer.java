package week08d04;

public class Trainer {

    private final CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer trainer1 = new Trainer(new GoodMood());
        Trainer trainer2 = new Trainer(new BadMood());

        System.out.println(trainer1.giveMark());
        System.out.println(trainer2.giveMark());
    }
}

// Mai Junior/Medior feladat:
// Hozz létre egy `CanMark` interfészt egy `int giveMark()` metódussal! Ez azt jelenti, hogy valaki
// tud osztályzatot adni. Ennek legyen két implementációja, egy `GoodMood`
// osztály, mely mindig `5` értéket ad vissza, és egy `BadMood` osztály, mely mindig `3` értéket ad vissza!
// Azaz jó hangulatban valaki mindig ötöst ad, rossz hangulatban hármast.
// Legyen egy `Trainer` osztály, melynek van egy `CanMark` attribútuma, mely konstruktorral állítható be! És
// legyen egy `int giveMark()` metódusa, mely továbbhív, azaz "delegál" a `CanMark` példány felé!
// Hozz létre a `main()` metódusban egy `Trainer` példányt, aki jó hangulatban van (azaz konstruktorban
// adj át neki egy `GoodMood` példányt, és egy másikat, aki `BadMood` példányt kap! Majd hívd meg
// a `giveMark()` metódusát mindkettőnek, és nézd meg, mit ad vissza!
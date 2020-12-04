package week06d05;

public class Bottle {

    BottleType type;
    int filledUntil = 0;

    public Bottle(BottleType type) {
        this.type = type;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }

    public void fill(int fillAmount) {
        if (filledUntil + fillAmount  > type.getMaximumAmount()) {
            throw new IllegalArgumentException("Nem fér bele!");
        }
        filledUntil += fillAmount;
    }

}

/*
Senior level csoport mai gyakorlati feladata:
Készíts a week06d05 csomagban egy Bottle nevű osztályt, amelynek van 2 attribútuma: BottleType type és int filledUntil.
A BottleType legyen felsorolásos típus az alábbi értékekkel: GLASS_BOTTLE és PET_BOTTLE, .
A Bottle nevű osztálynak legyen egy static metódusa of néven,
mely paraméterként egy BottleType-ot vár és visszaad egy új Bottle objektumot amelyet a megadott paraméter alapján hoz létre.
A Bottle osztálynak legyen egy fill metódusa, mely egy int fillAmount paramétert vár.
A fill meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a Bottle objektum.
Az ehhez szükséges int maximumAmount mezőt a BottleType tartalmazza! Ha túlcsordulna a Bottle objektum, akkor dobjunk kivételt!
*/
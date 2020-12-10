package week07d03;

import java.util.Objects;

public class Date {

    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return of(year, this.month, this.day);
    }

    public Date withMonth(int month) {
        return of(this.year, month, this.day);
    }

    public Date withDay(int day) {
        return of(this.year, this.month, day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year &&
                month == date.month &&
                day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

// Készítsünk a week07d03 csomagba egy Date osztályt, mely az alábbi attribútumokkal rendelkezik:
// int year, int month, int day. Az összes attribútum legyen final!
// Készítsünk továbbá egy statikus of metódust, mely a year, month és day paramétereket várja
// és létrehoz egy Date objektumot ezek alapján.
// Legyen továbbá a Date-nek egy withYear(int year), withMonth(int month) és egy withDay(int day) metódusa,
// melyek egy új Date objektumot adnak vissza az eredeti Date objektum adataival, azzal a különbséggel,
// hogy az új objektum a megadott paraméter értékét tartalmazza a megfelelő helyen (year, month vagy day).

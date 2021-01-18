package week12d01;

import java.util.Arrays;

public class GradeRounder {

    public int[] roundGrades2(int[] grades) { // Ádám megoldása, kicsit szebb
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > 40) {
                int floor = grades[i] / 5;
                int next = (floor + 1) * 5;
                if (next - grades[i] < 3) {
                    grades[i] = next;
                }
            }
        }
        return grades;
    }

    public int[] roundGrades(int[] grades) {
        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int actualNum = grades[i];
            if (actualNum < 40) {
                result[i] = actualNum;
            } else {
                if (actualNum % 5 > 2) {
                    result[i] = actualNum + (actualNum % 5) - 1;
                } else {
                    result[i] = actualNum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new GradeRounder().roundGrades(new int[]{33, 40, 83, 86, 93, 92, 91});
        System.out.println(Arrays.toString(a));
        int[] b = new GradeRounder().roundGrades2(new int[]{33, 40, 83, 86, 93, 92, 91});
        System.out.println(Arrays.toString(b));
    }
}

// Mai junior/medior feladat:
// Készíts egy GradeRounder osztályt, amiben van egy int[] roundGrades(int[] grades) metódus.
// A grades tömb pontszámokat tartalmaz 0 és 100 között.
// A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint:
// Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb, mint 3,
// akkor kerekítsük fel a számot az 5 következő többszörösére.
// Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
// Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.
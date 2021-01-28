package week12d03;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int tmp;
        for (int i = ages.length - 1; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (ages[j] > ages[j + 1]) {
                    tmp = ages[j + 1];
                    ages[j + 1] = ages[j];
                    ages[j] = tmp;
                }
            }
        }
        return ages;
    }

    public int[] sortAges2(int[] ages) {
        int tmp;
        for (int i = 0; i < ages.length - 2; i++) {
            for (int j = i + 1; j < ages.length - 1; j++) {
                if (ages[i] > ages[j]) {
                    tmp = ages[i];
                    ages[i] = ages[j];
                    ages[j] = tmp;
                }
            }
        }
        return ages;
    }

    public static void main(String[] args) {
        int[] x = {3, 3, 1, 7, 4, 5, 2, 8};

        int[] result = new AgeSorter().sortAges(x);
        for (int item : result) {
            System.out.print(item + " ");
        }
        System.out.println();
        int[] result2 = new AgeSorter().sortAges2(x);
        for (int item : result2) {
            System.out.print(item + " ");
        }
    }

}

// Senior
//
// Készítsünk egy osztályt `AgeSorter` néven, melynek van egy `int[] sortAges(int[] ages)` metódusa.
// Az `ages` tömbben emberek életkorai szerepelnek. A feladat az, hogy visszaadjunk egy tömböt,
// mely az életkorokat tartalmazza sorrendbe rendezve.
// Ne használjunk beépített sorrendbe rendező algoritmusokat (`Collections.sort`) a feladat megoldásához!
package arrays;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = new int[12];
        for (int i = 1; i <=12; i++) {
            YearMonth yearMonthObject = YearMonth.of(2020, i);
            numberOfDays[i-1] = yearMonthObject.lengthOfMonth();
        }
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        String[] days = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        return Arrays.asList(days);
    }

    public String multiplicationTableAsString(int size) {
        int[][] m = new int[size][size];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                m[i - 1][j - 1] = i * j;
            }
        }
        return Arrays.deepToString(m);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.daysOfWeek());
        System.out.println(arraysMain.multiplicationTableAsString(4));
    }
}

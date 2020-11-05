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

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] a, int[] b) {
        return false;
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println(arraysMain.daysOfWeek());
        System.out.println(arraysMain.multiplicationTableAsString(4));

        double[] day1 = {2.1, 5.6, 11.0, 16.1, 10.9};
        double[] day2 = {2.1, 4.6, 10.1, 16.1, 10.8};
        double[] day3 = {2.1, 5.6, 11.0, 16.1, 10.9};
        System.out.println("day1-day2: " + arraysMain.sameTempValues(day1, day2));
        System.out.println("day1-day3: " + arraysMain.sameTempValues(day1, day3));

        int[] a = {55, 12, 69, 90, 2};
        int[] b = {1, 90, 2, 44, 71};

    }
}

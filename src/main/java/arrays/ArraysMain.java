package arrays;

import java.time.YearMonth;
import java.util.Arrays;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = new int[12];
        for (int i = 1; i <=12; i++) {
            YearMonth yearMonthObject = YearMonth.of(2020, i);
            numberOfDays[i-1] = yearMonthObject.lengthOfMonth();
        }
        return Arrays.toString(numberOfDays);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
    }
}

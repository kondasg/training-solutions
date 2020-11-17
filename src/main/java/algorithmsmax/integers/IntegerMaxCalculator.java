package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public int max(List<Integer> nums) {
        int max = 0;
        for (int num: nums) {
            if ( max < num ) max = num;
        }
        return max;
    }
}

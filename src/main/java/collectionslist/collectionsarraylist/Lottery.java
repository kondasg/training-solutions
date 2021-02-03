package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> result = new ArrayList<>(lotteryType);
        int num;
        for (int i = 0; i < lotteryType; i++) {
            do {
                num = generateNumber(ballCount);
            }
            while (result.contains(num));
            result.add(num);
        }
        Collections.sort(result);
        return result;
    }

    public int generateNumber(int max) {
        return new Random().nextInt(max) + 1;
    }

}

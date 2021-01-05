package week10d02;

import java.util.List;

public class MaxTravel {

    private static final int MAX_STOP = 30;
    int[] ascend = new int[MAX_STOP];

    public int getMaxIndex(List<Integer> stations) {
        init();
        for (int item: stations) {
            ascend[item] = ascend[item] + 1;
        }
        return max();
    }

    public int max() {
        int max = ascend[0];
        int index = 0;
        for (int i=0; i<ascend.length; i++) {
            if (max < ascend[i]) {
                max = ascend[i];
                index = i;
            }
        }
        return index;
    }

    public void init() {
        for (int i=0; i<MAX_STOP; i++) {
            ascend[i] = 0;
        }
    }

}

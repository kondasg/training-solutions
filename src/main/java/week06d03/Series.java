package week06d03;

import java.util.List;

public class Series {

    public String calculateSeriesType(List<Integer> source) {
        if (source.size() < 2) {
            throw new IllegalArgumentException("");
        }
        boolean up = false;
        boolean down = false;
        int prevNum = source.get(0);
        for (int i = 1; i < source.size(); i++) {
            if (prevNum > source.get(i)) {
                down = true;
            } else {
                up = true;
            }
            prevNum = source.get(i);
        }
        return output(up, down);
    }

    public String output(boolean up, boolean down) {
        String text = "";
        if (up & down) {
            text = "vegyes";
        } else if (up) {
            text = "növekvő";
        } else {
            text = "csökkenő";
        }
        return text;
    }
}

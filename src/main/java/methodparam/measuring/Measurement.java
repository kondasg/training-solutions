package methodparam.measuring;

import java.util.ArrayList;
import java.util.List;

public class Measurement {

    private final double[] data;

    public Measurement(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("");
        }
        this.data = data;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] > lower && data[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min = data[0];
        for (double d: data) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public double maximum() {
        double max = data[0];
        for (double d: data) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }

}

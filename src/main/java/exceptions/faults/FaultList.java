package exceptions.faults;

import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException();
        }
        List<String> faults = new ArrayList<>();
        for (String line: lines) {
            String[] data = line.split(",");
            int num = validNumber(data[0]);
            if ( num >= 0) {
                if (data.length != 3) {
                    faults.add(num + ", " + ProcessingResult.WORD_COUNT_ERROR.getCode());
                }
                else {
                    int data1 = validNumber(data[0]);
                }
            }
        }
        return faults;
    }

    private int validNumber(String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }


}

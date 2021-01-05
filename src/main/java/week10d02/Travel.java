package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Travel {

    private static final int MAX_STOP = 30;
    int[] ascend = new int[MAX_STOP];

    public int getStopWithMax(String file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Travel.class.getResourceAsStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                int x = Integer.parseInt(data[0]);
                ascend[x] = ascend[x] + 1;
            }

            return max();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int max() {
        int max = ascend[0];
        int index = 0;
        for (int i = 0; i < ascend.length; i++) {
            if (max < ascend[i]) {
                max = ascend[i];
                index = i;
            }
        }
        return index;
    }

}

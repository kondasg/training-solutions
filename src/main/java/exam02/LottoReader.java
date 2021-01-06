package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private final int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                for (int i=11; i<16; i++) {
                    int num = Integer.parseInt(data[i]);
                    numbers[num-1] += 1;
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int getNumber(int number) {
        return numbers[number-1];
    }
}

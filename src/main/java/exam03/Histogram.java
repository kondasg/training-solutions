package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader reader) {
        try (BufferedReader br = reader) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < Integer.parseInt(line); i++) {
                    result.append("*");
                }
                result.append("\n");
            }
            return result.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Read error", e);
        }
    }
}

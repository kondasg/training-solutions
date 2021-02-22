package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private final Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split("=");
                owls.put(splittedLine[0], Integer.parseInt(splittedLine[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Read error", e);
        }
    }

    public int getNumberOfOwls(String county) {
        return owls.get(county);
    }
}

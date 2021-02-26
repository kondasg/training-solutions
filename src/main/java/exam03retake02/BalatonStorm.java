package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) {
        List<String> storms = new ArrayList<>();
        try {
            String line;
            String station = "";
            while ((line = reader.readLine()) != null) {
                station = stationContains(line, station);
                levelContains(storms, line, station);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
        storms.sort(Collator.getInstance(new Locale("hu", "HU")));
        return storms;
    }

    private void levelContains(List<String> storms, String line, String station) {
        if (line.contains("\"level\":")) {
            String[] splittedLine = line.split(":");
            if (Integer.parseInt(splittedLine[1].trim().substring(0, splittedLine[1].length() - 2)) == 3) {
                storms.add(station);
            }
        }
    }

    private String stationContains(String line, String station) {
        if (line.contains("\"allomas\":")) {
            String[] splittedLine = line.split(":");
            station = splittedLine[1].trim().substring(1, splittedLine[1].length() - 3);
        }
        return station;
    }
}

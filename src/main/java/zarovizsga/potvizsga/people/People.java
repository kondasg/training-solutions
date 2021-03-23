package zarovizsga.potvizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            int countMale = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(",");
                if (splittedLine[4].equals("Male")) {
                    countMale++;
                }
            }
            return countMale;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

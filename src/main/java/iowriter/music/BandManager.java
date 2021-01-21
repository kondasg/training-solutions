package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private final List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(";");
                bands.add(new Band(splittedLine[0], Integer.parseInt(splittedLine[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            for (Band band : oldBands(year)) {
                writer.write(band.getName() + ";" + band.getYear());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    private List<Band> oldBands(int year) {
        List<Band> result = new ArrayList<>();
        for (Band band : bands) {
            if (band.getYear() < year) {
                result.add(band);
            }
        }
        return result;
    }
}

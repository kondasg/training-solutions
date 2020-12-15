package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private final List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return countries;
    }

    public void readCountry() {
        Path file = Path.of("countries.txt");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] col = line.split(" ");

                countries.add(new Country(col[0], Integer.parseInt(col[1]), Integer.parseInt(col[2]), Integer.parseInt(col[3])));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public Country maxPopulaton() {
        int maxPopulation = 0;
        int index = 0;
        for (int i = 0; i < countries.size(); i++) {
            if (maxPopulation < countries.get(i).getPopulation()) {
                maxPopulation = countries.get(i).getPopulation();
                index = i;
            }
        }
        return countries.get(index);
    }

    public static void main(String[] args) {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readCountry();
        System.out.println(countryStatistics.maxPopulaton().toString());
    }


}

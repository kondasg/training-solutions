package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private final List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                countryList.add(new Country(splittedLine[0], Integer.parseInt(splittedLine[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public int numberOFCountries() {
        return getCountryList().size();
    }

    public Country mostBorderCountries() {
        Country result = countryList.get(0);
        for (Country country : countryList) {
            if (country.getBorderCountries() > result.getBorderCountries()) {
                result = country;
            }
        }
        return result;
    }

}

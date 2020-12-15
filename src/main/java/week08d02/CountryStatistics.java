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
        Country maxPopulation = countries.get(0);
        for (Country country: countries) {
            if (maxPopulation.getPopulation() < country.getPopulation()) {
                maxPopulation = country;
            }
        }
        return maxPopulation;
    }

    public static void main(String[] args) {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readCountry();
        System.out.println(countryStatistics.maxPopulaton().toString());
    }


}

// Adott a countries.txt állomány, melyet helyezz el a projekt gyökérkönyvtárába.
// A fájlban az adatok a következők: ország_neve népesség hány_színű_a_zászló szomszédos_országok_száma.
// Készíts a week08d02 csomagba egy CountryStatistics osztályt melyben van egy metódus,
// ami az adatokat beolvassa egy listába.
// A lista legyen az osztály privát attribútuma, és legyen hozzá getter metódus,
// figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát.
// Készíts egy metódust maxPopulaton() néven, ami a listából visszaadja a legnagyobb népességű ország minden adatát.

// countries.txt
//        Nepal 31 3 2
//        Csad 13 3 6
//        Kongoi_Demokratikus_Koztarsasag 79 3 9
//        Honduras 8 2 3
//        Kirgizisztán 6 2 4
//        Dzsibuti 1 4 3
//        Togo 7 4 3
//        Kambodzsa 15 3 3
//        Guyana 1 5 3
//        Albánia 3 2 4
//        Libanon 4 3 2
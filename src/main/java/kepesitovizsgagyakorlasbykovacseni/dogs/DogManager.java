package kepesitovizsgagyakorlasbykovacseni.dogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DogManager {

    private List<Dog> dogs;

    public String getCountryByExactDogSpecies(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        readCsv();
        for (Dog dog : dogs) {
            if (name.toUpperCase().equals(dog.getName())) {
                return dog.getCountry();
            }
        }
        throw new IllegalArgumentException("No such dog name found.");
    }

    public List<Dog> getDogsInAlphabeticalOrderByName() {
        readCsv();
        List<Dog> result = new ArrayList<>(dogs);
        result.sort(new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return result;
    }

    public Map<String, Integer> getDogStatistics() {
        readCsv();
        Map<String, Integer> result = new HashMap<>();
        for (Dog dog : dogs) {
            if (result.containsKey(dog.getCountry())) {
                result.put(dog.getCountry(), result.get(dog.getCountry()) + 1);
            } else {
                result.put(dog.getCountry(), 1);
            }
        }
        return result;
    }

    public void readCsv() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(DogManager.class.getResourceAsStream("dogs.csv")))) {
            String line;
            dogs = new ArrayList<>();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(";");
                dogs.add(new Dog(splittedLine[1], splittedLine[4], splittedLine[5]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

// https://github.com/kovacseni/kepesitovizsga-gyakorlas
// Kutyák
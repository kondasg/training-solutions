package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cities {

    public String nameOfTheLongestCity(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String city = "";
            int lenght = 0;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(";");
                if (lenght < splittedLine[1].length()) {
                    city = splittedLine[1];
                    lenght = splittedLine[1].length();
                }
            }
            return city;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Cities().nameOfTheLongestCity(Cities.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")));
    }

}

// Mai Junior feladat:
// A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
// Add vissza a leghosszabb nevű várost!
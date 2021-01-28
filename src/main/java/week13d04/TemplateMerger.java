package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try {
            String tempString = Files.readString(file);
            String output;
            StringBuilder sb = new StringBuilder();
            for (Employee employee : employees) {
                output = tempString.replace("{nev}", employee.getName());
                output = output.replace("{ev}", employee.getYearOfBirth() + "");
                sb.append(output);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

// Mai junior feladat:
// Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
// metódust, ami felolvassa a fájlt, melynek tartalma:
//
// Az alkalmazott neve: {nev}, születési éve: {ev}
//
// Nyugodtan beolvashatod egy utasítással!
// Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
// mint ahogy a fájlban van, azaz:
//
// Az alkalmazott neve: John Doe, születési éve: 1980
// Az alkalmazott neve: Jack Doe, születési éve: 1990
//
// (Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.

package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                ExamplesStore.class.getResourceAsStream("examples.md")))) {
            String line;
            List<String> titles = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    titles.add(line);
                }
            }
            return titles;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ExamplesStore().getTitlesOfExamples());
    }
}

//    Mai Senior feladat:
//        Legyen a classpath-on egy `examples.md` fájl, mely a gyakorlati feladatok leírásait tartalmazza
//        a következő formátumban! A `ExamplesStore` osztályba írj egy `getTitlesOfExamples()`
//        metódust, mely visszaadja a feladatok címeit egy listában!
//
// examples.md
//        # Első feladat
//        Írj egy programot, amely
//        kiírja az összeadás eredményét!
//        # Második feladat
//        Írj egy programot,
//        mely kiírja a kivonás eredményét!

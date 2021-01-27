package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teachers {

    public int hourByTeacher(InputStream inputStream, String name) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int counter = 1;
            String teacher = "";
            int hours = 0;
            while ((line = reader.readLine()) != null) {
                if (counter % 4 == 1) {
                    teacher = line;
                }
                if (counter % 4 == 0 && teacher.equals(name)) {
                    hours += Integer.parseInt(line);
                }
                counter++;
            }
            return hours;
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Teachers().hourByTeacher(Teachers.class.getResourceAsStream("/beosztas.txt"), "Albatrosz Aladin"));
    }
}

// Mai Junior/Mid-level feladat (`week13d03`):
// Adott a következő szerkezetű fájl, beosztas.txt:
// Albatrosz Aladin
// biologia
// 9.a
// 2
// Albatrosz Aladin
// osztalyfonoki
// 9.a
// 1
// Csincsilla Csilla
// matematika
// 9.b
// 2
// A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg.
// Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
// Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.
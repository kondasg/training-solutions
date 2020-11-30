package week06d01;

import java.util.List;

public class ListSelector {

    public String select(List<String> inputs) {
        if (inputs == null) {
            throw new IllegalArgumentException("List is null!");
        }
        if (inputs.size() == 0) {
            return "";
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < inputs.size(); i++) {
            if (i % 2 == 0) {
                output.append(inputs.get(i));
            }
        }
        return "[" + output.toString() + "]";
    }
}

//Írj egy olyan metódust az week06d01.ListSelector osztályban, mely egy kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
//A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
//Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista null, akkor dobjunk IllegalArgumentExceptiont a metódusban.

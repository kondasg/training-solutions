package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public enum Tutors {
    A("Nagy Csilla", List.of(Subjects.MATH, Subjects.BIO)),
    B("Nagy Béla", List.of(Subjects.GEO, Subjects.CHE, Subjects.MATH)),
    C("Kovács Rita", List.of(Subjects.PHY, Subjects.GEO) ),
    D("Varga Márton", List.of(Subjects.MUSIC, Subjects.BIO) );

    private final String name;
    private List<Subjects> subjects = new ArrayList<>();

    Tutors(String name, List<Subjects> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }


}

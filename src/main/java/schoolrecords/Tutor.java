package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private final String name;
    private List<Subject> taughtSubject = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubject) {
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        return false;
    }
}

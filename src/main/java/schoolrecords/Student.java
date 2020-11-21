package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Mark> marks = new ArrayList<>();
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) { // *érdemjegy rögzítése

    }

    public double calculateAverage() { // *teljes átlag számolása
        return 0.0;
    }

    public double calculateSubjectAverage(Subject subject) { // *tantárgyhoz tartozó átlag számítása
        return 0.10;
    }

    public String toString() { // *diák szöveges reprezentációja
        return "";
    }

    public boolean isEmpty(String s) {
        return (s == null || "".equals(s));
    }
}

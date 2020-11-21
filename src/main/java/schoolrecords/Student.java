package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Student {

    private final List<Mark> marks = new ArrayList<>();
    private final String name;

    public Student(String name) {
        if (isEmpty(name)) throw new IllegalArgumentException("Student name must not be empty!");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) { // *érdemjegy rögzítése
        if (mark == null) throw new NullPointerException("Mark must not be null!");
        marks.add(mark);
    }

    public double calculateAverage() { // *teljes átlag számolása
        if (marks.size() == 0) return 0.0;
        else {
            int sum = 0;
            for (Mark mark : marks) {
                sum += mark.getMarkType().getValue();
            }
            double a = (double) sum / marks.size();

            String avg = String.format(new Locale("en", "UK"), " %.2f", a);
            return Double.parseDouble(avg);
        }
    }

    public double calculateSubjectAverage(Subject subject) { // *tantárgyhoz tartozó átlag számítása
        if (marks.size() == 0) return 0.0;
        else {
            int sum = 0;
            int subjectSize = 0;
            double a = 0;
            for (Mark mark : marks) {
                if (subject.getSubjectName().equals(mark.getSubject().getSubjectName())) {
                    sum += mark.getMarkType().getValue();
                    subjectSize++;
                }
            }
            if (subjectSize != 0) a = (double) sum / subjectSize;

            String avg = String.format(new Locale("en", "UK"), " %.2f", a);
            return Double.parseDouble(avg);
        }
    }

    public String toString() { // *diák szöveges reprezentációja
        StringBuilder result = new StringBuilder();
        int newLine = 0;
        for (Mark mark : marks) {
            if (newLine > 0) {
                result.append("\n");
            }
            newLine++;
            result.append(name).append(" marks: ").append(mark.getSubject().getSubjectName()).append(": ").append(mark.toString());
        }
        return result.toString();
    }

    public boolean isEmpty(String s) {
        return (s == null || "".equals(s));
    }
}

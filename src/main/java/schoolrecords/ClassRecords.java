package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ClassRecords {

    private final String className;
    private final Random rnd;
    private final List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) throw new IllegalArgumentException();
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) { // *felvesz egy diákot az osztályba
        for (Student value : students) {
            if (value.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) { // *kivesz egy diákot az osztályból
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(student.getName())) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage() { // *osztályátlagot számol, minden diákot figyelembe véve
        if (students.size() == 0)
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        double sum = 0;
        for (Student student : students) {
            sum += student.calculateAverage();
        }
        if (sum == 0) throw new ArithmeticException("No marks present, average calculation aborted!");
        double a = sum / students.size();

        String avg = String.format(new Locale("en", "UK"), " %.2f", a);
        return Double.parseDouble(avg);
    }

    public double calculateClassAverageBySubject(Subject subject) { // *tantárgy szerinti osztályátlagot számol, kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
        if (students.size() == 0)
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        double sum = 0;
        int subjectSize = 0;
        double a = 0;
        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) > 0) {
                sum += student.calculateSubjectAverage(subject);
                subjectSize++;
            }
        }
        if (subjectSize != 0) a = sum / subjectSize;

        String avg = String.format(new Locale("en", "UK"), " %.2f", a);
        return Double.parseDouble(avg);
    }

    public Student findStudentByName(String name) { // *név szerint megkeres egy diákot az osztályban
        if (isEmpty(name)) throw new IllegalArgumentException("Student name must not be empty!");
        if (students.size() == 0) throw new IllegalStateException("No students to search!");
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() { // *felelethez a listából random módon kiválaszt egy diákot
        if (students.size() == 0) throw new IllegalStateException("No students to select for repetition!");
        return students.get(rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() { // *a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi, és azok listáját adja vissza
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student student : students) {
            studyResultByNames.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResultByNames;
    }

    public String listStudentNames() { // *kilistázza a diákok neveit, vesszővel elválasztva
        StringBuilder sb = new StringBuilder();
        int separator = 0;
        for (Student student : students) {
            if (separator != 0) sb.append(", ");
            sb.append(student.getName());
            separator++;
        }
        return sb.toString();
    }

    public boolean isEmpty(String s) {
        return (s == null || "".equals(s));
    }
}

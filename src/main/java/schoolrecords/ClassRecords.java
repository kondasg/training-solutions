package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private final String className;
    private final Random rnd;
    private final List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) { // *felvesz egy diákot az osztályba
        return false;
    }

    public boolean removeStudent(Student student) { // *kivesz egy diákot az osztályból
        return false;
    }

    public double calculateClassAverage() { // *osztályátlagot számol, minden diákot figyelembe véve
        return 0.0;
    }

    public double calculateClassAverageBySubject(Subject subject) { // *tantárgy szerinti osztályátlagot számol, kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
        return 0.0;
    }

    public Student findStudentByName(String name) { // *név szerint megkeres egy diákot az osztályban
        return null;
    }

    public Student repetition() { // *felelethez a listából random módon kiválaszt egy diákot
        return null;
    }

    public List<StudyResultByName> listStudyResults() { // *a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi, és azok listáját adja vissza
        return null;
    }

    public String listStudentNames() { // *kilistázza a diákok neveit, vesszővel elválasztva
        return "";
    }

    public boolean isEmpty(String s) {
        return (s == null || "".equals(s));
    }
}

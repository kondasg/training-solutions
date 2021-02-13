package week14d03;

import java.util.*;

public class ClassNoteBook {

    private final List<Student> students;

    public ClassNoteBook(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> sortNotebook(){
        List<Student> result = new ArrayList<>();
        for (Student s : students) {        // copy konstruktorhoz tartozik, hogy ne tudjak hozzáadni az
            result.add(new Student(s));     // eredeti listához
        }                                   //
        Collections.sort(result);
        return result;
    }


}

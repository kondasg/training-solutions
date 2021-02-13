package week14d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void sortNotebook() {
        List<Student> students = List.of(
                new Student("Joe"),
                new Student("Jane"),
                new Student("Bill"),
                new Student("Jake"));
        ClassNoteBook classNoteBook = new ClassNoteBook(students);

        List<Student> result = classNoteBook.sortNotebook();

        assertEquals("Bill", result.get(0).getName());
        assertEquals("Joe", result.get(3).getName());

        result.add(new Student("XXX"));
        assertEquals(4, classNoteBook.getStudents().size());

        result.get(0).addMark("matematika", 3);
        assertEquals(0, classNoteBook.getStudents().get(2).getMarks().size());
    }
}
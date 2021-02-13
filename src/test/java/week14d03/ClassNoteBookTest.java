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
                new Student("Jane"));
        ClassNoteBook classNoteBook = new ClassNoteBook(students);

        assertEquals("Jane", classNoteBook.sortNotebook().get(1).getName());
    }
}
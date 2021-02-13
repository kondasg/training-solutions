package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void addMark() {
        Student student = new Student("Géza");

        student.addMark("matematika", 5);
        student.addMark("matematika", 4);
        student.addMark("fizika", 2);
        student.addMark("angol", 3);

        assertEquals(3, student.getMarks().size());
    }
}
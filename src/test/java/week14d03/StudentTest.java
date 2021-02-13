package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {


    @Test
    void create() {
        Student student = new Student("Géza");

        assertEquals("Géza", student.getName());
        assertEquals(0, student.getMarks().size());
    }

    @Test
    void addMark() {
        Student student = new Student("Géza");

        student.addMark("matematika", 5);
        student.addMark("matematika", 4);
        student.addMark("fizika", 2);
        student.addMark("angol", 3);

        assertEquals(3, student.getMarks().size());
        assertEquals(2, student.getMarks().get("matematika").size());
        assertEquals(3, student.getMarks().get("angol").get(0));
    }
}
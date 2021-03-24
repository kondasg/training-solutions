package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    void createTitle() {
        Lab lab = new Lab("title1");
        assertEquals("title1", lab.getTitle());
        assertFalse(lab.isCompleted());
    }

    @Test
    void createTitleAndDate() {
        Lab lab = new Lab("title2", LocalDate.of(2021, 1, 1));
        assertEquals("title2", lab.getTitle());
        assertEquals(LocalDate.of(2021, 1, 1), lab.getCompletedAt());
        assertTrue(lab.isCompleted());
    }

    @Test
    void complete() {
        Lab lab = new Lab("title3");
        lab.complete();
        assertEquals("title3", lab.getTitle());
        assertEquals(LocalDate.now(), lab.getCompletedAt());
        assertTrue(lab.isCompleted());
    }

    @Test
    void completeDate() {
        Lab lab = new Lab("title3");
        lab.complete(LocalDate.of(2021, 1, 1));
        assertEquals("title3", lab.getTitle());
        assertEquals(LocalDate.of(2021, 1, 1), lab.getCompletedAt());
        assertTrue(lab.isCompleted());
    }

    @Test
    void testToString() {
        Lab lab = new Lab("title2", LocalDate.of(2021, 1, 1));
        assertEquals("title2 true 2021-01-01", lab.toString());
    }
}
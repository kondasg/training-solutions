package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void merge() {
        TemplateMerger templateMerger = new TemplateMerger();
        List<Employee> employees = List.of(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));
        String result = "Az alkalmazott neve: John Doe, születési éve: 1980\n" +
                "Az alkalmazott neve: Jack Doe, születési éve: 1990\n";
        assertEquals(result, templateMerger.merge(Path.of("src/main/resources/week13d04/temp.txt"), employees));
    }
}
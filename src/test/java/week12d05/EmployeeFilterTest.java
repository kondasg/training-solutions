package week12d05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterTest {

    @Test
    void countSeniorDevs() {
        EmployeeFilter employeeFilter = new EmployeeFilter();

        List<Employee> employees = List.of(
                new Employee(40, 2, "John Doe", List.of("programming", "multi-tasking", "flexibility")),
                new Employee(22, 3, "Joe Doe", List.of("collaboration")),
                new Employee(35, 4, "Jack Doe", List.of("sharing", "flexibility")),
                new Employee(26, 5, "Jane Doe", List.of("programming", "multi-tasking"))
        );

        assertEquals(1, employeeFilter.countSeniorDevs(employees).size());
        assertEquals("Jane Doe", employeeFilter.countSeniorDevs(employees).get(0).getName());
    }
}
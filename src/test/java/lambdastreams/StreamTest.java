package lambdastreams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamTest {

    List<Employee> employees = List.of(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    void testCount() {
        assertEquals(0, Stream.empty().count());
        assertEquals(2, Stream.of(new Employee("asd"), new Employee("asdasf")).count());

        Stream<Employee> s = Stream.of(new Employee("asd"), new Employee("asdasf"));
        assertEquals(2, s.count());

        assertEquals(4, employees.stream().count());
    }

    @Test
    void testMin() {
        Employee employee = employees.stream().min((e1, e2) -> e1.getName().compareTo(e2.getName())).get();
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    void testMax() {
        Employee employee = employees.stream().max((e1, e2) -> e1.getName().length() - e2.getName().length()).get();
        assertEquals("John Smith", employee.getName());
    }

    @Test
    void testFindFirst() {
        Employee employee = employees.stream().findFirst().get();
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void testAllMatch() {
        boolean res = employees.stream().allMatch(e -> e.getName().length() > 5);
        assertTrue(res);
        res = employees.stream().allMatch(e -> e.getName().startsWith("J"));
        assertTrue(res);
    }

    @Test
    void testForEach() {
        employees.stream().forEach(e -> e.setName(e.getName().toUpperCase()));
        assertEquals("JOHN DOE", employees.get(0).getName());
        //employees.stream().forEach(System.out::println);
    }
}
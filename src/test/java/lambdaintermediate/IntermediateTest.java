package lambdaintermediate;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntermediateTest {

    List<Employee> employees = List.of(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    void filter() {
        List<Employee> filtered =
                employees.stream()
                        .filter(e -> e.getName().startsWith("John"))
                        .collect(Collectors.toList());
        assertEquals(2, filtered.size());
        assertEquals("John Doe", filtered.get(0).getName());
    }

    @Test
    void distinct() {
        List<String> filtered =
                Stream.of("John", "Joe", "John", "Jim")
                        .distinct()
                        .collect(Collectors.toList());
        assertEquals(3, filtered.size());
        assertEquals("Jim", filtered.get(2));
    }

    @Test
    void skipLimit() {
        List<Employee> filtered =
                employees.stream()
                        .skip(1)
                        .limit(2)
                        .collect(Collectors.toList());
        assertEquals(2, filtered.size());
        assertEquals("Joe Doe", filtered.get(1).getName());
    }

    @Test
    void infinite() {
        // Stream.generate(Math::random).limit(5).forEach(System.out::println);
        List<Integer> l =
                Stream.iterate(1, n -> n + 2)
                        .skip(2)
                        .limit(3)
                        .collect(Collectors.toList());
        assertEquals(3, l.size());
        assertEquals(l, List.of(5, 7, 9));
    }

    @Test
    void map() {
        List<String> names =
                employees.stream()
                        .map(e -> e.getName())
                        .collect(Collectors.toList());
        assertEquals("Jane Doe", names.get(1));
    }

    @Test
    void flatMap() {
        List<String> s1 = List.of("John Doe", "Jane Doe");
        List<String> s2 = List.of("Jack Doe", "Joe Doe");
        List<String> names =
                Stream.of(s1, s2)
                        .flatMap(l -> l.stream())
                        .collect(Collectors.toList());
        assertEquals(4, names.size());
        assertEquals("Jack Doe", names.get(2));
    }

    @Test
    void sorted() {
        List<Employee> sorted =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getName))
                        .collect(Collectors.toList());
        assertEquals(4, sorted.size());
        assertEquals("Jane Doe", sorted.get(0).getName());
    }

    @Test
    void peek() {
        List<String> names =
                employees.stream()
                        .map(e -> e.getName())
                        .sorted()
                        .peek(System.out::println) // lazy
                        .limit(2)
                        .collect(Collectors.toList());
        System.out.println(names);
    }
}
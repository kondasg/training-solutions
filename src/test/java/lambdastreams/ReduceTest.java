package lambdastreams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReduceTest {

    List<Employee> employees = List.of(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("Jane John Smith")
    );

    @Test
    void testReduce() {
        int l = employees.stream().reduce(
                0,
                (i, e) -> i + e.getName().length(),
                Integer::sum);
        assertEquals(38, l);
    }

    @Test
    void testNameCounter() {
        NameCounter nameCounter = employees.stream().reduce(
                new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2)
        );
        assertEquals(1, nameCounter.getThreePartName());
        assertEquals(3, nameCounter.getTwoPartName());
    }

    @Test
    void testNameCounterCollect() {
        NameCounterMod nameCounterMod = employees.stream().collect(
                NameCounterMod::new,
                (nnc, e) -> nnc.add(e),
                (nnc1, nnc2) -> nnc1.add(nnc2));
        assertEquals(1, nameCounterMod.getThreePartName());
        assertEquals(3, nameCounterMod.getTwoPartName());
    }
}

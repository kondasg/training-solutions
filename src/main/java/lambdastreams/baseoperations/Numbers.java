package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {

    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Integer::compareTo);
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(n -> n > 0);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().collect(Collectors.toSet());
    }
}

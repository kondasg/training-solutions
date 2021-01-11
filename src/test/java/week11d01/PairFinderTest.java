package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairs() {
        int[] arr = {5, 1, 4, 5};
        assertEquals(1, new PairFinder().findPairs(arr));
    }

    @Test
    void findPairs2() {
        int[] arr = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, new PairFinder().findPairs(arr));
    }

    @Test
    void findPairs3() {
        int[] arr = {7, 1, 5, 7, 3, 3, 9, 7, 6, 7};
        assertEquals(3, new PairFinder().findPairs(arr));
    }
}
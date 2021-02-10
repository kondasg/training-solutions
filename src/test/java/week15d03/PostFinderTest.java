package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void findPostsFor() {
        List<Post> l = List.of(
                new Post("Title1", LocalDate.of(2020,1,1), "Content1",  "Owner1"),
                new Post("Title2", LocalDate.of(2021,5,1), "Content2",  "Owner1"),
                new Post("Title3", LocalDate.of(2020,1,1), "Content3",  "Owner1"),
                new Post("Title4", LocalDate.of(2020,1,1), "Content4",  "Owner2")
        );
        PostFinder postFinder = new PostFinder(l);

        assertEquals(2, postFinder.findPostsFor("Owner1").size());

    }
}
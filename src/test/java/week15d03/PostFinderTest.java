package week15d03;

import org.junit.jupiter.api.Test;
import stringscanner.StringScanner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    List<Post> l = List.of(
            new Post("Title1", LocalDate.of(2020,1,1), "Content1",  "Owner1"),
            new Post("Title2", LocalDate.of(2021,5,1), "Content2",  "Owner1"),
            new Post("Title3", LocalDate.of(2020,1,1), "Content3",  "Owner1"),
            new Post("Title4", LocalDate.of(2020,1,1), "Content4",  "Owner2")
    );
    PostFinder postFinder = new PostFinder(l);

    @Test
    void userIsNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor(null));
        assertEquals("user is empty or null!", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor(""));
        assertEquals("user is empty or null!", ex.getMessage());
    }

    @Test
    void postIsNull() throws IllegalArgumentException {
        l = List.of(new Post(null, LocalDate.of(2020,1,1), "Content4",  "Owner1"));
        postFinder = new PostFinder(l);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor("Owner1"));
        assertEquals("Post argument is null", ex.getMessage());

        l = List.of(new Post(null, null, "Content4",  "Owner1"));
        postFinder = new PostFinder(l);
        ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor("Owner1"));
        assertEquals("Post argument is null", ex.getMessage());

        l = List.of(new Post(null, null, null,  "Owner1"));
        postFinder = new PostFinder(l);
        ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor("Owner1"));
        assertEquals("Post argument is null", ex.getMessage());

        l = List.of(new Post(null, null, null,  null));
        postFinder = new PostFinder(l);
        ex = assertThrows(IllegalArgumentException.class, () -> postFinder.findPostsFor("Owner1"));
        assertEquals("Post argument is null", ex.getMessage());
    }

    @Test
    void findPostsFor() {
        assertEquals(2, postFinder.findPostsFor("Owner1").size());
    }
}
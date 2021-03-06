package week05d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaylistTest {

    @Test
    void Test() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("A", 59, "AA"));
        songs.add(new Song("B", 159, "BB"));
        songs.add(new Song("C", 54, "CC"));
        songs.add(new Song("D", 599, "DD"));

        Playlist playlist = new Playlist(songs);

        assertEquals(2, playlist.findByLengthGreaterThan(1).size());
    }

    @Test
    void Test2() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Song("", 1, "artist") );
        assertEquals("The name cannot be empty.", iae.getMessage());
    }

    @Test
    void Test3() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Song("name", 1, "") );
        assertEquals("The artist cannot be empty.", iae.getMessage());
    }

    @Test
    void Test4() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Song("name", -12, "artist") );
        assertEquals("The length must be greater than zero.", iae.getMessage());
    }


}

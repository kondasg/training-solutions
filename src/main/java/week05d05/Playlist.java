package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    List<Song> songs = new ArrayList<>();

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> finded = new ArrayList<>();
        for (Song song: songs) {
            if (song.getLengthInSeconds() > mins*60) finded.add(song);
        }
        return finded;
    }
}

package week05d05;

public class Song {

    private final String name;
    private final long lengthInSeconds;
    private final String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        if (isEmpty(artist)) {
            throw new IllegalArgumentException("The artist cannot be empty.");
        }
        if (lengthInSeconds < 0) {
            throw new IllegalArgumentException("The length must be greater than zero.");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }

    @Override
    public String toString() {
        return artist + ":" + name + " (" + lengthInSeconds + " sec)";
    }
}

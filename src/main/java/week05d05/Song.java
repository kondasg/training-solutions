package week05d05;

public class Song {

    private final String name;
    private final long lengthInSeconds;
    private final String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmpty(name) || isEmpty(artist)) throw new IllegalArgumentException("Empty");
        if (lengthInSeconds < 0) throw new IllegalArgumentException("Lenght is 0");
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

package activitytracker;

public class Image {

    private int id;
    private final String filename;
    private final byte[] content;

    public Image(int id, String filename, byte[] content) {
        this(filename, content);
        this.id = id;
    }

    public Image(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }
}

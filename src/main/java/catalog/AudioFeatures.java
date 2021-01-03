package catalog;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        if (isBlank(title)) throw new IllegalArgumentException();
        if (length < 0) throw new IllegalArgumentException();
        if (isEmpty(performers)) throw new IllegalArgumentException();
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!isEmpty(composer)) contributors.addAll(composer);
        if (!isEmpty(performers)) contributors.addAll(performers);
        return contributors;
    }
}

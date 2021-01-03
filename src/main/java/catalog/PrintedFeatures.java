package catalog;

import static catalog.Validators.isBlank;
import static catalog.Validators.isEmpty;

import java.util.List;

public class PrintedFeatures implements Feature {

    private final List<String> authors;
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (isBlank(title)) throw new IllegalArgumentException("Empty title");
        if (numberOfPages < 0) throw new IllegalArgumentException();
        if (isEmpty(authors)) throw new IllegalArgumentException();
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }
}

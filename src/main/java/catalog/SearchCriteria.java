package catalog;

import static catalog.Validators.isBlank;

public class SearchCriteria {

    public String contributor;
    public String title;

    private SearchCriteria(String title, String contributor) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (isBlank(title)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (isBlank(title)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(title, "");
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (isBlank(contributor)) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria("", contributor);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasTitle() {
        return !isBlank(getTitle());
    }

    public boolean hasContributor() {
        return !isBlank(getContributor());
    }

}

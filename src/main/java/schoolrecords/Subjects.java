package schoolrecords;

public enum Subjects {
    GEO("földrajz"),
    MATH("matematika"),
    BIO("biológia"),
    MUSIC("zene"),
    PHY("fizika"),
    CHE("kémia");

    private final String name;

    Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}

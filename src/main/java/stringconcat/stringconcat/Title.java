package stringconcat.stringconcat;

public enum Title {

    MR ("Mr."), MRS ("Mrs."), DR ("Dr.");

    private final String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

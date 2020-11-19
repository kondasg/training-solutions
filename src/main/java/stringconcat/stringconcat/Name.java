package stringconcat.stringconcat;

public class Name {

    private final String familyName;
    private final String middleName;
    private final String givenName;
    Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);
        this.title = title;
    }
    public Name(String familyName, String middleName, String givenName) {
        if ( isEmpty(familyName) ) throw new IllegalArgumentException("Family name and given name must not be empty!");
        if ( isEmpty(givenName) ) throw new IllegalArgumentException("Family name and given name must not be empty!");
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public boolean isEmpty(String s) {
        return (s == null || s.equals(""));
    }

    public String concatNameWesternStyle() {
        String name = "";

        if (title != null) name += title.getValue() + " ";
        if (!isEmpty(givenName)) name += givenName + " ";
        if (!isEmpty(middleName)) name += middleName + " ";
        if (!isEmpty(familyName)) name += familyName;

        return name;
    }

    public String concatNameHungarianStyle() {
        String name = "";

        if (title != null) {
            name = name.concat(title.getValue());
            name = name.concat(" ");
        }
        if (!isEmpty(familyName)) {
            name = name.concat(familyName);
            name = name.concat(" ");
        }
        if (!isEmpty(middleName)) {
            name = name.concat(middleName);
            name = name.concat(" ");
        }
        if (!isEmpty(givenName)) name = name.concat(givenName);

        return name;
    }

}

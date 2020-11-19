package stringbuilder.stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) throw new IllegalArgumentException("Family name and given name must not be empty!");

        StringBuilder stringBuilder = new StringBuilder();

        if (title != null) {
            stringBuilder.append(title.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append(givenName.trim());
        stringBuilder.append(" ");
        if (!isEmpty(middleName)) {
            stringBuilder.append(middleName.trim());
            stringBuilder.append(" ");
        }
        stringBuilder.append(familyName.trim());

        return stringBuilder.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) throw new IllegalArgumentException("Family name and given name must not be empty!");

        StringBuilder stringBuilder = new StringBuilder();

        if (title != null) {
            stringBuilder.append(title.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append(familyName.trim());
        stringBuilder.append(" ");
        if (!isEmpty(middleName)) {
            stringBuilder.append(middleName.trim());
            stringBuilder.append(" ");
        }
        stringBuilder.append(givenName.trim());

        return stringBuilder.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name.trim());
        stringBuilder.insert(name.indexOf(where), " " + title.getValue());
        return stringBuilder.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name.trim());
        int index = name.indexOf(delete);
        stringBuilder.delete(index, index + delete.length());

        return stringBuilder.toString();
    }

    public boolean isEmpty(String str) {
        return (str == null || "".equals(str.trim()));
    }
}

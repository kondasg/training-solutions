package week04;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName.equals("") || fullName == null) throw new IllegalArgumentException("Invalid Name:" + fullName);
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName) {
        int separator = fullName.indexOf(" ");
        String s1 = fullName.substring(0, separator);
        fullName = s1 + " " + firstName;
    }

    public String getFullName() {
        return fullName;
    }
}

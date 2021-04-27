package covid;

import java.time.LocalDate;

public class Citizen {

    private final String name;
    private final String zip;
    private final LocalDate birth;
    private final String email;
    private final String taj;

    public Citizen(String name, String zip, LocalDate birth, String email, String taj) {
        this.name = name;
        this.zip = zip;
        this.birth = birth;
        this.email = email;
        this.taj = taj;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }
}

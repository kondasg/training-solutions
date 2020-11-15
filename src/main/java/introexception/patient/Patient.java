package introexception.patient;

public class Patient {

    private final String name;
    private final String socialSecurityNumber;
    private final int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name.equals("")) throw new IllegalArgumentException("A név nem lehet üres!");
        if (yearOfBirth < 1900) throw new IllegalArgumentException("A születési év legyen legalább 1900!");
        if (!new SsnValidator().isValidSsn(socialSecurityNumber)) throw new IllegalArgumentException("Nem megfelelő TAJ szám!");
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public static void main(String[] args) {
        Patient patient = new Patient("John Doe", "123456789", 2000);

        System.out.println(patient.toString());
    }
}

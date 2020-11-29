package attributes.person;

public class Person {

    String name;
    String identificationCard;
    Address address;

    public String personToString() {
        return name + " (ID: " + identificationCard + ")";
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void moveTo(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

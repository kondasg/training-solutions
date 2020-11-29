package attributes.person;

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person();

        person.correctData("John Doe", "A123456");

        Address address = new Address("HU", "Bp", "Petőfi u. 1.", "1234");

        person.moveTo(address);

        System.out.println(person.getAddress());

        System.out.println(person.personToString());

    }
}

package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;

        Person person = new Person("John Doe", 50 );

        person1 = person;
        person2 = person1;

        person2.setName("John Doe mod");

        System.out.println(person1.getName());
        System.out.println(person2.getName());

        int a;
        int b;
        a = 24;
        b = a;
        b++;
        System.out.println(a);
        System.out.println(b);

        Person newPerson = new Person("Jack Doe", 30);
        person2 = newPerson;
        System.out.println(newPerson.getName());
        System.out.println(person2.getName());


    }
}

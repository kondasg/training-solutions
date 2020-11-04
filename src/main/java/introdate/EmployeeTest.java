package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nev:");
        String name = scanner.nextLine();
        System.out.println("Szül. év:");
        int year = scanner.nextInt();
        System.out.println("Szül. hó:");
        int month = scanner.nextInt();
        System.out.println("Szül. nap:");
        int day = scanner.nextInt();

        Employee employee = new Employee(name, year, month, day);

        // scanner.nextLine();

        System.out.println("Dolgozó adatai:");
        System.out.println("Név: " + employee.getName());
        System.out.println("Szül. idő: " + employee.getDateOfBirth());
        System.out.println("Belépés: " + employee.getBeginEmployment());

    }
}

package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client kliens = new Client();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a nevét: ");
        kliens.name = scanner.nextLine();
        System.out.println("Kérem a születési évét: ");
        kliens.year = scanner.nextInt();
        System.out.println("Kérem a címét: ");
        kliens.address = scanner.nextLine();

        System.out.println("A bekért adatok");

        System.out.println("Név: " + kliens.name);
        System.out.println("Születési év: " + kliens.year);
        System.out.println("Cím: " + kliens.address);
    }
}

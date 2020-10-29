package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Regisztráció");

        System.out.println("Kérem a nevét: ");
        String nev = scanner.nextLine();
        System.out.println("Kérem az e-mail címét: ");
        String email = scanner.nextLine();

        System.out.println("Regisztációs adatok: ");
        System.out.println("Név: " + nev);
        System.out.println("E-mail: " + email);
    }
}

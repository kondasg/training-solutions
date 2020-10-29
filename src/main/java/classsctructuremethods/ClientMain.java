package classsctructuremethods;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client kliens = new Client();

        Scanner scanner = new Scanner(System.in);

        kliens.setName("Aranka");
        kliens.setYear(2000);
        kliens.setAddress("1234 Bp., Mező u. 2.");

        System.out.println("A tárolt adatai");
        System.out.println("Név: " + kliens.getName());
        System.out.println("Év: " + kliens.getYear());
        System.out.println("Cím: " + kliens.getAddress());

        System.out.println("\nKérem az új címet: ");
        kliens.migrate(scanner.nextLine());

        System.out.println("\nÚj címét tároltuk: " + kliens.getAddress());

    }
}

package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Termék neve: ");
        String nev = scanner.nextLine();
        System.out.println("Termék ára: ");
        int ar = scanner.nextInt();

        Product termek = new Product(nev,ar);

        System.out.println("Mekkora az áremelés? ");
        int emel = scanner.nextInt();
        termek.increasePrice(emel);
        System.out.println(termek.getName() + " új ára " + termek.getPrice());

        System.out.println("Mekkora az akció? ");
        int akcio = scanner.nextInt();
        termek.decreasePrice(akcio);
        System.out.println(termek.getName() + " új ára " + termek.getPrice());

    }
}

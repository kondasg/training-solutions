package classstructureintegrate;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Számla1 név: ");
        String nev1 = scanner.nextLine();
        System.out.println("Számla1 száma: ");
        String szam1 = scanner.nextLine();
        System.out.println("Számla1 egyenleg: ");
        int egyenlg1 = scanner.nextInt();

        BankAccount szamla1 = new BankAccount(szam1,nev1,egyenlg1);

        System.out.println("Számla1 adatai: " + szamla1.getInfo());

        scanner.nextLine();

        System.out.println("\nSzámla2 név: ");
        String nev2 = scanner.nextLine();
        System.out.println("Számla2 száma: ");
        String szam2 = scanner.nextLine();
        System.out.println("Számla2 egyenleg: ");
        int egyenlg2 = scanner.nextInt();

        BankAccount szamla2 = new BankAccount(szam2,nev2,egyenlg2);

        scanner.nextLine();

        System.out.println("Számla2 adatai: " + szamla2.getInfo());

        System.out.println("--------");

        szamla1.deposit(1200);
        System.out.println("Számla1 befizetés (1200 Ft)\n" + szamla1.getInfo() );
        szamla2.withdraw(2500);
        System.out.println("Számla2 kivét (2500 Ft)\n" + szamla2.getInfo() );

        System.out.println("--------");

        System.out.println("Számla1-ról átutalás Számla2-re (500 Ft)\n" );
        szamla1.transfer(szamla2,500);
        System.out.println("Számla1 | " + szamla1.getInfo() );
        System.out.println("Számla2 | " + szamla2.getInfo() );

    }
}

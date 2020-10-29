package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Számológép");

        System.out.println("Kérem az első számot: ");
        int elso = scanner.nextInt();
        System.out.println("Kérem a második számot: ");
        int masodik = scanner.nextInt();

        System.out.println("Művelet: " + elso + " + " + masodik);
        System.out.println("Eredmény: " + (elso + masodik));
    }
}

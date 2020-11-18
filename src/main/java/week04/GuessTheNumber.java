package week04;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {



    public static void main(String[] args) {
        Random rnd = new Random();
        int randomInt = rnd.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        for ( i = 0; i < 6; i++) {
            System.out.print("Gondoltam egy számra: ");
            int tip = Integer.parseInt(scanner.nextLine());

            if (randomInt == tip) {
                System.out.println("Eltaláltad!");
                break;
            }
            else if (randomInt > tip) System.out.println("nagyobb!");
            else if (randomInt < tip) System.out.println("kisebb!");
        }
        if (i == 6) {
            System.out.println("\nElfogyott a tippelési lehetőséged!");
            System.out.println("\nErre gondoltam:" + randomInt);
        }
    }
}

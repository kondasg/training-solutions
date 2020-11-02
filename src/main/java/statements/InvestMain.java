package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Befektetés összege: ");
        int osszeg = scanner.nextInt();
        System.out.println("Kamatláb: ");
        int kamatlab = scanner.nextInt();
        Investment investment = new Investment(osszeg,kamatlab);

        System.out.println("Tőke: " + investment.getFund());
    }
}

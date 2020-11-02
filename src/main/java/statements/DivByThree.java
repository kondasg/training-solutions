package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérek egy számot: ");
        int num = scanner.nextInt();

        String o = ( num % 3 == 0 ) ? "osztható" : "nem osztható";

        System.out.println("A szám " + o + " 3-al" );
    }
}

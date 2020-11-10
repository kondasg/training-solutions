package numbers;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mennyi (5 + 3 * 4) / 3? ");
        double res = scanner.nextDouble();

        double x = (5 + 3 * 4) / 3d;

        System.out.println("Az eredmény: " + (Math.abs( x - res) < 0.0001 ));
    }
}

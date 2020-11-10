package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kör 1. átmérő? ");
        int d1 = scanner.nextInt();
        System.out.print("Kör 2. átmérő? ");
        int d2 = scanner.nextInt();

        Circle circle1 = new Circle(d1);
        Circle circle2 = new Circle(d2);

        System.out.println(circle1.perimeter());
        System.out.println(circle1.area());
        System.out.println(circle2.perimeter());
        System.out.println(circle2.area());

    }
}


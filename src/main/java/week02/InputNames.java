package week02;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = new String[5];

        for (int i = 1; i <=5 ; i++) {
            System.out.println("Kérem az " + i + ". nevet: ");
            names[i-1] = scanner.nextLine();
        }

        for (String name: names) {
            System.out.println(name);
        }
    }
}

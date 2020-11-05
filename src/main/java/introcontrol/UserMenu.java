package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = "1. Felhasználók listázása";
        String s2 = "2. Felhasználó felvétele";
        String s3 = "Többi: Kilépés";

        System.out.println(s1 + "\n" + s2 + "\n" + s3);

        System.out.print("Menü választás: ");
        int num = scanner.nextInt();

        if (num==1 || num==2) {
            if (num==1) {
                System.out.println(s1);
            } else {
                System.out.println(s2);
            }
        }
    }
}

package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név:");
        String username = scanner.nextLine();
        System.out.println("Jelszó:");
        String psw1 = scanner.nextLine();
        System.out.println("Jelszó még1x:");
        String psw2 = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        UserValidator userValidator = new UserValidator();

        String s = userValidator.isValidUsername(username) ? "helyes" : "helytelen";
        System.out.println("felhasználónév: " + s);
        System.out.println("jelszó: " + userValidator.isValidPassword(psw1,psw2));
        System.out.println("email : " + userValidator.isValidEmail(email));
    }
}

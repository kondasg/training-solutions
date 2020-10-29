package hello;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Mi a neved?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}

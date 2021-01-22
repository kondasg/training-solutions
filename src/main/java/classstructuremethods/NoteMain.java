package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note jegyzet = new Note();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        jegyzet.setName(scanner.nextLine());
        System.out.println("Topic: ");
        jegyzet.setTopic(scanner.nextLine());
        System.out.println("Text: ");
        jegyzet.setText(scanner.nextLine());

        System.out.println("\n"+jegyzet.getNoteText());
    }
}

package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song zene = new Song();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kedvenc zenéd adatai: ");
        System.out.println("Előadó: ");
        zene.band = scanner.nextLine();
        System.out.println("Cím: ");
        zene.title = scanner.nextLine();
        System.out.println("Hossz: ");
        zene.length = scanner.nextInt();

        System.out.println("Kedvenc zenéd adatai: " + zene.band + " - " + zene.title + " (" + zene.length + " perc)");
    }
}

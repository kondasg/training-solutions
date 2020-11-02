package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem az első időpont adatait:");
        System.out.println("Óra: ");
        int hour1 = scanner.nextInt();
        System.out.println("Perc: ");
        int min1 = scanner.nextInt();
        System.out.println("Másodperc: ");
        int sec1 = scanner.nextInt();

        Time time1 = new Time(hour1,min1,sec1);

        System.out.println("Kérem a második időpont adatait:");
        System.out.println("Óra: ");
        int hour2 = scanner.nextInt();
        System.out.println("Perc: ");
        int min2 = scanner.nextInt();
        System.out.println("Másodperc: ");
        int sec2 = scanner.nextInt();

        Time time2 = new Time(hour2,min2,sec2);

        System.out.println("Az első időpont " + time1.toString() + " = " + time1.getInMinutes() + " perc");
        System.out.println("Az második időpont " + time2.toString() + " = " + time2.getInSeconds() + " másodperc");
        System.out.println("Az első korábbi, mint a második: " + time1.earlierThan(time2));

    }
}

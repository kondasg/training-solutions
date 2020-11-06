package week02;

import java.util.Scanner;

public class Controller {
    Office office = new Office();
    public static final String[] MENU = {"1. Tárgyalók sorrendben",
                                        "2. Tárgyalók visszafele sorrendben",
                                        "3. Minden második tárgyaló",
                                        "4. Területek",
                                        "5. Keresés pontos név alapján",
                                        "6. Keresés névtöredék alapján",
                                        "7. Keresés terület alapján",
                                        "8. Kilépés"};

    public void readOffice() {

        /* tesztadat
        MeetingRoom meetingRoom2 = new MeetingRoom("Vilma", 3, 4);
        office.addMeetingRoom(meetingRoom2);
        MeetingRoom meetingRoom = new MeetingRoom("AlMa", 1, 2);
        office.addMeetingRoom(meetingRoom);
        MeetingRoom meetingRoom3 = new MeetingRoom("Mamma", 11, 21);
        office.addMeetingRoom(meetingRoom3);
        MeetingRoom meetingRoom4 = new MeetingRoom("Izé", 6, 6);
        office.addMeetingRoom(meetingRoom4);
        */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hány darab tárgyalót szeretne rögzíteni? ");
        int numbersOfMeetingRooms = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numbersOfMeetingRooms; i++) {
            System.out.print("Tárgyaló " + i + " neve: ");
            String nameOfOfMeetingRoom = scanner.nextLine();
            System.out.print("Tárgyaló " + i + " szélessége méterben: ");
            int lengthOfOfMeetingRoom = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Tárgyaló " + i + " hosszúsága méterben: ");
            int widthOfOfMeetingRoom = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(nameOfOfMeetingRoom, lengthOfOfMeetingRoom, widthOfOfMeetingRoom);
            office.addMeetingRoom(meetingRoom);
        }
    }

    public void printMenu() {
        System.out.println("\nMENÜ");
        for (String item: MENU) {
            System.out.println(item);
        }
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nKérem válasszon a menüpontok közül: ");
        int numberOfMenu = scanner.nextInt();
        scanner.nextLine();

        if ( numberOfMenu >= 1 && numberOfMenu <=8 ) {
            System.out.println("\n" + MENU[numberOfMenu-1] + ":");
            if (numberOfMenu == 1) office.printNames();
            if (numberOfMenu == 2) office.printNamesReverse();
            if (numberOfMenu == 3) office.printEvenName();
            if (numberOfMenu == 4) office.printAreas();
            if (numberOfMenu == 5) {
                System.out.print("Kérem a nevet: ");
                office.printMeetingRoomsWithName(scanner.nextLine());
            }
            if (numberOfMenu == 6) {
                System.out.print("Kérem a névtöredéket: ");
                office.printMeetingRoomsContains(scanner.nextLine());
            }
            if (numberOfMenu == 7) {
                System.out.print("Kérem a területet: ");
                office.printAreasLargerThan(scanner.nextInt());
            }
            if (numberOfMenu == 8) System.exit(0);
        } else {
            runMenu();
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
       }
}

package week02d02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("telefon1 tip: ");
        String a = scanner.nextLine();
        System.out.println("telefon1 mem: ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.println("telefon2 tip: ");
        String c = scanner.nextLine();
        System.out.println("telefon2 mem: ");
        int d = scanner.nextInt();
        scanner.nextLine();

        Phone phone = new Phone(a, b);
        Phone phone2 = new Phone(c, d);

        System.out.println("telefon 1.: " + phone.getType() + ", mem: " + phone.getMem());
        System.out.println("telefon 2.: " + phone2.getType() + ", mem: " + phone2.getMem());
    }
}

package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] days = { "hétfő", "kedd", "szerda", "csütrötök", "péntek", "szombat", "vasárnap" };

        System.out.println(days[1]);
        System.out.println(days.length);

        System.out.println();

        int[] hatvany = new int[5];
        hatvany[0] = 1;

        for (int i = 1; i < hatvany.length; i++) {
            hatvany[i] = hatvany[i-1]*2;
        }

        for (int h: hatvany) {
            System.out.println(h);
        }

        System.out.println();

        boolean[] logikaiTomb = new boolean[6];

        for (int i = 1; i < logikaiTomb.length; i++) {
            logikaiTomb[i] = !logikaiTomb[i-1];
        }

        for (boolean l: logikaiTomb) {
            System.out.println(l);
        }
    }
}

package week08d01;

public class Sultan {

    private final boolean [] cells = new boolean[100];

    public void openDoors() {
        for (int day = 1; day <= 100; day++ ) {
            for (int cell = day; cell < cells.length + 1; cell++ ) {
                if (cell % day == 0) cells[cell - 1] = !cells[cell - 1];
            }
        }
    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan();
        sultan.openDoors();
        for (int i = 0; i < sultan.cells.length; i++) {
            if (sultan.cells[i]) System.out.println(i + 1);
        }
    }
}

/*
Mai Senior feladat:
A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből.
A börtönben 100 cella van. Mindegyik cella zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz,
ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.

A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet. (Ekkor minden cella nyitva lesz)
A második napon minden másodikon fordítsanak egyet, így minden második zárva lesz.
A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz.
A week08d01.Sultan osztályba írj egy metódust openDoors() néven,  aminek visszatérési értékéből kiderül,
hogy mely ajtók lesznek nyitva a 100. napon! Az osztály szabadon bővíthető!
*/

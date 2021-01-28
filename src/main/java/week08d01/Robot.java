package week08d01;

public class Robot {

    private int x = 0;
    private int y = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String move(String action) {
        for (int i = 0; i < action.length(); i++) {
            switch (action.toUpperCase().charAt(i)) {
                case 'F' -> up();
                case 'L' -> down();
                case 'B' -> left();
                case 'J' -> right();
                default -> throw new IllegalArgumentException("");
            }
        }
        return "x: " + getX() + ", y: " + getY();
    }

    private void up() {
        this.y++;
    }

    private void down() {
        this.y--;
    }

    private void left() {
        this.x--;
    }

    private void right() {
        this.x++;
    }
}

// Junior
//
// A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban van.
// A robot négy irányba képes mozogni fel, le, balra és jobbra.
// A `week08d01.Robot` osztályban írj egy `move()` metódust ami egy karaktersorozatot vár.
// pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
// A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
// A feladat szabadon bővíthető osztályokkal és metódusokkal.
//
// Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét,
// akkor dobjunk IllegalArgumentExceptiont!

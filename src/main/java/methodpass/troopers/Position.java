package methodpass.troopers;

import static java.lang.Math.sqrt;

public class Position {

    private final double posX;
    private final double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        return sqrt( (posX - position.posX) * (posX - position.posX) + (posY - position.posY) * (posY - position.posY) );
    }
}

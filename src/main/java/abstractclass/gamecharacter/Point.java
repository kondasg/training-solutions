package abstractclass.gamecharacter;

public class Point {

    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point point) {
        return (long) Math.sqrt(
                Math.pow(point.getX() - this.getX(), 2)
                        +
                        Math.pow(point.getY() - this.getY(), 2));
    }
}

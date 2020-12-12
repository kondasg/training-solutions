package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private final Point position;
    private int hitPoint = 100;
    private final Random random;

    public Character(Point position, Random random) {
        this.random = random;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public boolean isAlive() {
        return hitPoint > 0;
    }

    protected int getActualPrimaryDamage() {
        return random.nextInt(10) + 1;
    }

    private int getActualDefence() {
        return random.nextInt(5);
    }

    protected void hit(Character enemy, int damage) {
        if (enemy.getActualDefence() < damage) {
            enemy.decreaseHitPoint(damage);
        }
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    abstract public void secondaryAttack(Character enemy);
}

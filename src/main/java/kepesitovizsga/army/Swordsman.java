package kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean shield;
    private int attack;

    public Swordsman(boolean armor) {
        super(100, 10, armor);
        shield = true;
    }

    @Override
    protected int doDamage() {
        return damage;
    }

    @Override
    protected void sufferDamage(int damage) {
        attack++;
        if (!shield) hitPoints -= (armor) ? damage / 2 : damage;
        if (attack == 1) shield = false;
    }
}

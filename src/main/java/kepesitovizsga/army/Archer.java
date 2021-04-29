package kepesitovizsga.army;

public class Archer extends MilitaryUnit {

    public Archer() {
        super(50, 20, false);
    }

    @Override
    protected int doDamage() {
        return damage;
    }

    @Override
    protected void sufferDamage(int damage) {
        hitPoints -= (armor) ? damage / 2 : damage;
    }
}

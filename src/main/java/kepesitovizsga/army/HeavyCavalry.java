package kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private int attack;

    public HeavyCavalry() {
        super(150, 20 ,true);
    }

    @Override
    protected int doDamage() {
        attack++;
        return (attack == 1) ? damage * 3 : damage;
    }

    @Override
    protected void sufferDamage(int damage) {
        hitPoints -= (armor) ? damage / 2 : damage;
    }
}

package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    public int getActualSecondaryDamage() {
        return getActualPrimaryDamage() * 2;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().distance(enemy.getPosition()) < 2) {
            hit(enemy, getActualSecondaryDamage());
        }
//        hogy ha az ellenség közelebb van mint két egység (használd a Point distance metódust),
//        akkor meghívja az örökölt hit() metódust, átadva a kapott enemy paramétert
//        és a getActualSecondaryDamage() metódus visszatérési értékét.
    }
}

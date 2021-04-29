package kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {

    private final List<MilitaryUnit> military = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        military.add(militaryUnit);
    }

    public void damageAll(int damage) {
        Iterator<MilitaryUnit> it = military.iterator();
        while (it.hasNext()) {
            MilitaryUnit militaryUnit = it.next();
            militaryUnit.sufferDamage(damage);
            if (militaryUnit.hitPoints < 25) {
                it.remove();
            }
        }
    }

    public int getArmyDamage() {
        int result = 0;
        for (MilitaryUnit militaryUnit : military) {
            result += militaryUnit.doDamage();
        }
        return result;
    }

    public int getArmySize() {
        return military.size();
    }

}

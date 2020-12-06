package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive pd = pendrives.get(0);
        for (Pendrive pendrive: pendrives) {
            if (pd.comparePricePerCapacity(pendrive) == 1) {
                pd = pendrive;
            }
        }
        return pd;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive pd = pendrives.get(0);
        for (Pendrive pendrive: pendrives) {
            if (pendrive.cheaperThan(pd)) {
                pd = pendrive;
            }
        }
        return pd;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive: pendrives) {
            if (capacity == pendrive.getCapacity()) {
                pendrive.risePrice(percent);
            }
        }
    }
}

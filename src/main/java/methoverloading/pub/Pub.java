package methoverloading.pub;

import methoverloading.Time;

public class Pub {

    private final String name;
    private final Time openFrom;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.openFrom = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openFrom;
    }

    public String toString() {
        return name + ";" + openFrom.getHours() + ":" + openFrom.getMinutes();
    }
}

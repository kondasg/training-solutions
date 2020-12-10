package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        int diff = 24*60;
        int index = 0;
        for (int i = 0; i < timeTable.size(); i++) {
            int actualDiff = timeTable.get(i).difference(actual);
            if (actualDiff > 0 && actualDiff < diff) {
                diff = timeTable.get(i).difference(actual);
                index = i;
            }
        }
        if (index == 0 && diff == 24*60)  {
            throw new IllegalStateException("No more buses today!");
        }
        else  return timeTable.get(index);
    }

    public SimpleTime firstBus() {
        int diff = 24*60;
        int index = 0;
        SimpleTime actual = new SimpleTime(0,0);
        for (int i = 0; i < timeTable.size(); i++) {
            int actualDiff = timeTable.get(i).difference(actual);
            if ( actualDiff < diff) {
                diff = timeTable.get(i).difference(actual);
                index = i;
            }
        }
        return timeTable.get(index);
    }
}

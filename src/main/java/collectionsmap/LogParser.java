package collectionsmap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {

    private final static String ROW_SEPARATOR = "\n";
    private final static String COL_SEPARATOR = ":";
    private final static String DATE_SEPARATOR = "-";
    private final static int COL_NUM = 3;

    public Map<String, List<Entry>> parseLog(String log) {
        if (log == null || log.isEmpty()) {
            throw new IllegalArgumentException("Incorrect log: null or empty");
        }
        Map<String, List<Entry>> result = new HashMap<>();
        String[] rows = log.split(ROW_SEPARATOR);
        for (String row : rows) {
            String[] item = row.split(COL_SEPARATOR);
            if (item.length != COL_NUM) {
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            if (!item[1].contains(DATE_SEPARATOR)) {
                throw new IllegalArgumentException("Incorrect log: incorrect date");
            }
            String[] splittedDate = item[1].split(DATE_SEPARATOR);
            LocalDate ld = LocalDate.of(
                    Integer.parseInt(splittedDate[0]),
                    Integer.parseInt(splittedDate[1]),
                    Integer.parseInt(splittedDate[2]));
            Entry e = new Entry(item[2], item[0], ld);
            List<Entry> le = new ArrayList<>();
            if (result.containsKey(item[0])) {
                le = result.get(item[0]);
            }
            le.add(e);
            result.put(item[0], le);
        }
        return result;
    }
}

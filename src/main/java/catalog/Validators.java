package catalog;

import java.util.List;

public class Validators {

    static boolean isBlank(String string) {
        return string == null || "".equals(string.trim());
    }

    static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }
}

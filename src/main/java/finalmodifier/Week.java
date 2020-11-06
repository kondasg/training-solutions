package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {
    public static final List<String> DAY = Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "casárnap");

    public static void main(String[] args) {
        System.out.println(DAY);
        DAY.set(1, "Szerda");
        System.out.println(DAY);
    }
}

package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> nums) {
        List<Integer> duplicates = new ArrayList<>();
        List<Integer> ok = new ArrayList<>();
        for (Integer num: nums) {
            if (ok.contains(num)) {
                duplicates.add(num) ;
            } else {
                ok.add(num);
            }
        }

        return duplicates;
    }
}

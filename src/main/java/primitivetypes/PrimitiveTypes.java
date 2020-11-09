package primitivetypes;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypes {

    public static final int BIN_BITS = 32;

    public String toBinaryString(int n) {
        List<Integer> bin = new ArrayList<>();
        for ( int i = n; i > 0; ) {
            bin.add(i % 2);
            i = i / 2;
        }
        String s = "";
        for ( int i = 1; i <= BIN_BITS - bin.size(); i++ ) {
            s += "0";
        }
        for (int i = bin.size()-1; i >= 0; i-- ) {
            s += bin.get(i);
        }
        return s;
    }
}

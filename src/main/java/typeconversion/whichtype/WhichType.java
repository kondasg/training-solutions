package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> types = new ArrayList<>();

        for (Type item: Type.values() ) {
             if ( ( item.getLongMin() < Long.parseLong(s)) && ( item.getLongMax() > Long.parseLong(s) )) {
                types.add(item);
            }
        }
        return types;
    }

    public static void main(String[] args) {
        System.out.println(new WhichType().whichType("5600"));
    }
}

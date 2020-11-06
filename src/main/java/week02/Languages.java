package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    public static void main(String[] args) {

        List<String> langs = new ArrayList<>();
        langs.add("Java");
        langs.add("Python");
        langs.add("JavaScript");

        for(String item: langs){
            if (item.length() > 5) {
                System.out.println(item);
            }
        }
    }
}

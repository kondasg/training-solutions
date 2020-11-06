package week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    public static void main(String[] args) {

        List<String> langList = new ArrayList<>();
        langList.add("Java");
        langList.add("Python");
        langList.add("JavaScript");

        for(String item: langList){
            if (item.length()>5) {
                System.out.println(item);
            }
        }
    }
}

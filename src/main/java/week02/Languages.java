package week02;

import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        String[] langs = {"Java", "Python", "Javascript"};
        String[] langList = langs;

        for(String item: langList){
            if (item.length()>5) {
                System.out.println(item);
            }
        }
    }
}

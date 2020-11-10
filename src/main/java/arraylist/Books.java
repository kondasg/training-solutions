package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private final List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> searchResult = new ArrayList<>();
        for (String title: titles) {
            if (title.indexOf(prefix) == 0) {
                searchResult.add(title);
            }
        }
        return searchResult;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Alma");
        books.add("Körte");
        books.add("Körte és Alma");
        books.add("körte és Körte");
        books.add("BirsAlma");
        System.out.println(books.getTitles());

        System.out.println(books.findAllByPrefix("Alma"));
        System.out.println(books.findAllByPrefix("alma"));
        System.out.println(books.findAllByPrefix("Körte"));
    }
}

package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        new Book();

        Book book = new Book();
        System.out.println(book);

        Book emptyBook = null;
        System.out.println(emptyBook);

        if (emptyBook == null) {
            System.out.println("emptyBook is null");
        } else {
            System.out.println("emptyBook is not null");
        }

        Book anotherBook = new Book();
        if (book == anotherBook) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        anotherBook = book;
        System.out.println(anotherBook);
        if (book == anotherBook) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        System.out.println(anotherBook instanceof Book);

/* */

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;

        // A következő kód hány objektumot hoz létre? 4
        // A futás végére mennyi objektumhoz lehet hozzáférni? 5

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6);
        System.out.println(book7);

/* */

        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> bookList = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(new Book());
        bookList2.add(new Book());
        bookList2.add(new Book());
    }
}

package collectionsequalshash;

import java.util.*;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book searc = new Book(title, author);
        if (!books.contains(searc)) {
            return null;
        }
        return books.get(books.indexOf(searc));
    }

    public Book findBook(List<Book> books, Book book) {
        if (!books.contains(book)) {
            return null;
        }
        return books.get(books.indexOf(book));
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> booksSet = new HashSet<>();
        for (Book book : books) {
            booksSet.add(book);
        }
        return booksSet;
    }
}

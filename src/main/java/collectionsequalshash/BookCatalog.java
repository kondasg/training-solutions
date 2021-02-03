package collectionsequalshash;

import java.util.*;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book search = new Book(title, author);
        if (!books.contains(search)) {
            return null;
        }
        return books.get(books.indexOf(search));
    }

    public Book findBook(List<Book> books, Book book) {
        if (!books.contains(book)) {
            return null;
        }
        return books.get(books.indexOf(book));
    }

    public Set<Book> addBooksToSet(Book[] books) {
        return new HashSet<>(Arrays.asList(books));
    }
}

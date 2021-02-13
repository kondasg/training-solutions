package searching;

import java.util.Arrays;

public class BookArraySearch {

    private final Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author == null || title == null
                || author.isEmpty() || title.isEmpty()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book book = new Book(author, title);
        Arrays.sort(bookArray);
        int index = Arrays.binarySearch(bookArray, book);
        if (index < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return bookArray[index];
    }
}

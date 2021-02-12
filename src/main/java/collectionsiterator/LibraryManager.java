package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private final Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Book actual : libraryBooks) {
            if (regNumber == actual.getRegNumber()) {
                return actual;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> i = libraryBooks.iterator();
        while (i.hasNext()) {
            if (regNumber == i.next().getRegNumber()) {
                i.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book actual = i.next();
            if (author.equals(actual.getAuthor())) {
                result.add(actual);
            }
        }
        if (result.size() == 0) {
            throw new MissingBookException("No books found by Tolkien");
        }
        else {
            return result;
        }
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}

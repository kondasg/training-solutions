package sorting;

import java.util.Set;

public class OrderedLibrary {

    private final Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        for (Book book: library) {
            return book;
        }
        throw new NullPointerException("Libray is empty!");
    }
}

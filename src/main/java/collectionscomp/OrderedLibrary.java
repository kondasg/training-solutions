package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private final List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> result = new ArrayList<>(libraryBooks);
        Collections.sort(result);
        return result;
    }

    public List<Book> orderedByAuthor() {
        List<Book> result = new ArrayList<>(libraryBooks);
        Collections.sort(result, new AuthorComparator());
        return result;
    }

//    public List<Book> orderedByAuthor() {
//        Collections.sort(libraryBooks, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o1.getAuthor().compareTo(o2.getAuthor());
//            }
//        });
//        return new ArrayList<>(libraryBooks);
//    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> result = new ArrayList<>();
        for (Book book : libraryBooks) {
            result.add(book.getTitle());
        }
        Collections.sort(result, Collator.getInstance(locale));
        return result;
    }

}

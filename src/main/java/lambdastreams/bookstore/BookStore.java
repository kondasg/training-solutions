package lambdastreams.bookstore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public long getNumberOfBooks() {
        return books.stream().reduce(0, (b1, b2) -> b1 + b2.getPiece(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max((b1, b2) -> b1.getYear() - b2.getYear());
    }

    public int getTotalValue() {
        return books.stream().reduce(0, (b1, b2) -> b1 + b2.getPrice() * b2.getPiece(), Integer::sum);
    }

    public List<Book> getByYearOfPublish(int year) {
        return books.stream().collect(Collectors.groupingBy(Book::getYear)).get(year);
    }
}

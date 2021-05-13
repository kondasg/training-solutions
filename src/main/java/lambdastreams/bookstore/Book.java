package lambdastreams.bookstore;

public class Book {

    private final String title;
    private final int year;
    private final int price;
    private final int piece;

    public Book(String title, int year, int price, int piece) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.piece = piece;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getPiece() {
        return piece;
    }
}

package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("könyv");

        System.out.println(book.getTitle());

        book.setTitle("új könyv");

        System.out.println(book.getTitle());
    }
}

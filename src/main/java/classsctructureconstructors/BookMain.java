package classsctructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Robin Cook", "Kóma");

        book.register("1234");

        System.out.println("(" + book.getRegNumber()+") " + book.getAuthor() + " - " + book.getTitle());
    }
}

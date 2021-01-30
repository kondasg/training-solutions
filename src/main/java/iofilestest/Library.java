package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> library = new ArrayList<>();

    public List<Book> getLibrary() {
        return new ArrayList<>(library);
    }

    public void add(Book... books) {
        for (Book book : books) {
            if (!isContain(book)) {
                library.add(book);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Book libraryBook : library) {
                bw.write(libraryBook.getAuthor() + ": " + libraryBook.getTitle() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public void loadBooks(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(": ");
                add(new Book(splittedLine[0], splittedLine[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

    private boolean isContain(Book book) {
        for (Book libraryBook : library) {
            if (book.getAuthor().equals(libraryBook.getAuthor()) &&
                    book.getTitle().equals(libraryBook.getTitle())) {
                return true;
            }
        }
        return false;
    }
}

package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library = new Library();

    void fillLibrary() {
        library.add(
                new Book("a", "aa"),
                new Book("b", "bb"),
                new Book("c", "cc"),
                new Book("a", "aa"),
                new Book("ac", "aa")
        );
    }

    @TempDir
    public File folder;

    @Test
    void testAdd() {
        fillLibrary();
        assertEquals(4, library.getLibrary().size());
    }

    @Test
    void testSaveBooks() throws IOException {
        fillLibrary();
        Path file = new File(folder, "library.txt").toPath();
        library.saveBooks(file);

        List<String> writtenLines = Files.readAllLines(file);

        assertEquals("a: aa", writtenLines.get(0));
        assertEquals("c: cc", writtenLines.get(2));
        assertEquals("ac: aa", writtenLines.get(3));
    }

    @Test
    void testLoadBooks() {
        Path file = Path.of("src/test/resources/library.txt");
        library.loadBooks(file);

        assertEquals(4, library.getLibrary().size());
        assertEquals("a", library.getLibrary().get(0).getAuthor());
        assertEquals("cc", library.getLibrary().get(2).getTitle());
        assertEquals("ac", library.getLibrary().get(3).getAuthor());
    }
}
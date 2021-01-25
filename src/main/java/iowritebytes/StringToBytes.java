package iowritebytes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> words, Path file) {
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (String word: words) {
                if (!word.startsWith("_")) {
                    os.write(word.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }
}

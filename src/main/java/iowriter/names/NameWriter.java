package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    Path file;

    public NameWriter(Path fileName) {
        this.file = fileName;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            writer.write(name);
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }
}

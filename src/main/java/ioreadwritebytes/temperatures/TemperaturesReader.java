package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path file = Path.of(pathString);

        try {
            byte[] data = Files.readAllBytes(file);
            return new Temperatures(data);
        } catch (IOException e) {
            throw new IllegalStateException("Cant read file", e);
        }
    }
}

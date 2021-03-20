package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] source, Path file) {
        try (BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(file.resolve("image.png")))) {
            for (byte[] data : source) {
                os.write(data);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }
}

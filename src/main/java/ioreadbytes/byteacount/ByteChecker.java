package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String dataFile) {
        try (InputStream inputStream = new BufferedInputStream(
                Files.newInputStream(Path.of("src/main/resources/ioreadbytes/" + dataFile)))) {
            byte[] bytes = new byte[1000];
            int size;
            int sum = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                for (int i = 0; i < size; i++ ) {
                    if (bytes[i] == 'a') {
                        sum++;
                    }
                }
            }
            return sum;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

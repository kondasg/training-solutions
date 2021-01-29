package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path file, List<String> names) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
            zipOutputStream.putNextEntry(new ZipEntry("names.dat"));
            for (String item: names) {
                zipOutputStream.write(item.getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can'r write zip file", e);
        }
    }
}

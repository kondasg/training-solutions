package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    Path file;
    private final List<Human> humans = new ArrayList<>();

    public FileManager(String file) {
        this.file = Path.of(file);
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(file);
            for (String name: names) {
                String[] splittedName = name.split(" ");
                humans.add(new Human(splittedName[0], splittedName[1]));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public Path getMyFile() {
        return file;
    }


}

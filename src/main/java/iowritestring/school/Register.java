package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
            }
            else {
                Files.writeString(file, mark + "\n");
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public void average(Path file) {
        try {
            if (Files.exists(file)) {
                List<String> lines = Files.readAllLines(file);
                int sum = 0;
                for (String mark : lines) {
                    sum += Integer.parseInt(mark);
                }
                double average = (double) sum / lines.size();
                Files.writeString(file, "average: " + average + "\n", StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}

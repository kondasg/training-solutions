package ioprintwriter.salary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private final List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(Files.newBufferedWriter(file)))) {
            for (String name: names) {
                if (name.startsWith("Dr")) {
                    writer.println(name + ": " + 500000);
                }
                else if (name.startsWith("Mr") || name.startsWith("Mrs")) {
                    writer.println(name + ": " + 200000);
                }
                else {
                    writer.println(name + ": " + 100000);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }
}

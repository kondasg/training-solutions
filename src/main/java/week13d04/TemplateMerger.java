package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try {
            String tempString = Files.readString(file);
            String output;
            StringBuilder sb = new StringBuilder();
            for (Employee employee: employees) {
                output = tempString.replace("{nev}", employee.getName());
                output = output.replace("{ev}", employee.getYearOfBirth() + "");
                sb.append( output );
                sb.append( "\n" );
            }
            return sb.toString();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public static void main(String[] args) {
        TemplateMerger templateMerger = new TemplateMerger();
        List<Employee> employees = List.of(new Employee("John Doe", 11), new Employee("Jack Doe", 22));
        System.out.println(templateMerger.merge(Path.of("temp.txt"), employees));
    }
}

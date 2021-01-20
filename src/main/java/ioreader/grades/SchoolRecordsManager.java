package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readGradesFromFile(String fileName) {
        Path file = Path.of(fileName);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                List<Integer> gradeList = new ArrayList<>();
                for (int i = 1; i < splittedLine.length; i++) {
                    gradeList.add(Integer.parseInt(splittedLine[i]));
                }
                students.add(new Student(splittedLine[0], gradeList));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("");
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.average();
        }
        return sum / students.size();
    }
}
